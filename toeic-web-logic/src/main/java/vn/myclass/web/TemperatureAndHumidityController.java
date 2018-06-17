package vn.myclass.web;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vn.myclass.core.common.util.TemperatureAndHumidity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/CheckHumidity")
public class TemperatureAndHumidityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static void sendData (HttpServletResponse respons){
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Humidity = "Check";
        String SendData = "Send";
//        JSONObject obj = new JSONObject();
//        JSONArray list = new JSONArray();
//        for(int i = 1 ; i <=24 ; i++){
//            list.put(i);
//        }
//        try {
//            obj.put("ValueCheck" , 100);
//            obj.put("Stringvalue", list);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println(obj);
//
        String json = request.getParameter("value");
//        System.out.println(json);
//        response.setContentType("application/json");
//        response.setContentType("text/plain");
//        response.getWriter().write(String.valueOf(obj));
            if(json.equals(Humidity)){
                try {
                    JSONObject jsonObject = TemperatureAndHumidity.getJson("Mongcai", "VietNam");
                    JSONArray jsonArray = jsonObject.getJSONArray("DailyForecasts");
                    Integer TemperatureMin = jsonArray.getJSONObject(0).getJSONObject("Temperature").getJSONObject("Minimum").getInt("Value");
                    Integer TemperatureMax = jsonArray.getJSONObject(0).getJSONObject("Temperature").getJSONObject("Maximum").getInt("Value");
                    System.out.println(TemperatureMin);
                    JSONObject jsonObject2 = new JSONObject();
                    jsonObject2.put("ValueCheck" , 2);
                    jsonObject2.put("Stringvalue",TemperatureMin);
                    response.setContentType("application/json");
                    response.setContentType("text/plain");
                    response.getWriter().write(String.valueOf(jsonObject2));

//                    if(TemperatureMin < 27){
//
//                        response.setContentType("application/json");
//                        response.setContentType("text/plain");
//                        String jsonStr = "{\"a\": \"1\"}";
//                        PrintWriter out = response.getWriter();
//                        out.print(jsonStr);
//
//
//                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (org.json.simple.parser.ParseException e) {
                    e.printStackTrace();
                }
            }
    }
}
