package vn.myclass.web;


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import vn.myclass.core.dto.SensorDTO;
import vn.myclass.core.service.SensorService;
import vn.myclass.core.service.impl.SensorServiceImpl;
import vn.myclass.login.LoginController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;


@WebServlet("/SendDataToESP")
public class SocketServerController extends HttpServlet {

    SensorDTO sensorDTO = new SensorDTO();
    boolean flag = true;
    PrintWriter writer;
    DatagramSocket serverSocket;
    String value;



    // lay du lieu tu ESP8266
    public static String getDataFromESP(DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException {
        String sentence = new String( receivePacket.getData());
        serverSocket.receive(receivePacket);
        return sentence;
    }

    // xu ly du lieu tu ESP8266
    public static void ProcessValue(DatagramSocket serverSocket, DatagramPacket receivePacket, String sentence, SensorDTO sensorDTO, SensorService sensorService) throws IOException, JSONException {
        sentence = getDataFromESP(serverSocket, receivePacket);
        Date date = new Date( );

        try{
            org.json.JSONObject jsonObject = new org.json.JSONObject(sentence);
            int sensorHumidity =  jsonObject.getInt("H1");
            int sensorWaterFlow = jsonObject.getInt("W1");
            float sensorPH = (float) jsonObject.getDouble("P1");
            sensorDTO.setSensorHumidity(sensorHumidity);
            sensorDTO.setSensorWater(sensorWaterFlow);
            sensorDTO.setSensorPH(sensorPH);
            sensorDTO.setCreatedDate(date);
            System.out.println(jsonObject);
            sensorService.Save(sensorDTO);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    // gui du lieu ve ESP8266
    public static void sendValueToESP(DatagramSocket serverSocket, String value, int port, InetAddress IPAddress) throws IOException {
        byte[] sendData = new byte[100];
        JSONObject obj = new JSONObject();
            sendData = obj.toJSONString().getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
    }

     // mo Server
    public static  DatagramSocket serverSocket() throws SocketException {
        DatagramSocket serverSocket = new DatagramSocket(3000);
        serverSocket.setSoTimeout(10000*1000);
        return serverSocket;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SensorService sensorService = new SensorServiceImpl();
        HttpSession session = request.getSession(true);
        String checkSession = (String) session.getAttribute("user");
        if( value.equals("Page") ){
            serverSocket = serverSocket();          // check server
        }
        byte[] receiveData = new byte[1024];
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        writer = response.getWriter();
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        int index  = 0 , i =0;
//        checkServer = "BatSensor";
        while(flag){
            String sentence = getDataFromESP(serverSocket, receivePacket);
            if(index == 0){
                sendValueToESP(serverSocket, value, port, IPAddress);
            }
            index = 1;
            try {
                ProcessValue(serverSocket, receivePacket, sentence, sensorDTO , sensorService);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                writer.write("event:sensorHumidity\n");
                writer.write("data: " + sensorDTO.getSensorHumidity() + "\n\n");

                writer.write("event:sensorWaterFlow\n");
                writer.write("data: " + sensorDTO.getSensorWater() + "\n\n");

                writer.write("event:sensorPH\n");
                writer.write("data: " + sensorDTO.getSensorPH() + "\n\n");
                writer.flush();
                i++;
        }
        serverSocket.close();
    }
}