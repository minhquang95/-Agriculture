// udp client

#include <ESP8266WiFi.h>
#include <WiFiUdp.h>
#include <SoftwareSerial.h>
WiFiUDP Udp;
const char *ssid = "Dinh Dat"; 
const char *password = "01653860170";
char packetBuffer[255];
char incomingPacket[255];  
char  replyPacekt[] = "Hi there! Got the message :-)"; 
unsigned int localPort = 9999;
IPAddress ipServer(192, 168, 1, 60);
IPAddress ipClient(192, 168, 1, 92);
IPAddress Subnet(255, 255, 255, 0);



void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);
  WiFi.mode(WIFI_STA); // STA important !!!
  WiFi.config(ipClient, ipServer, Subnet);
  Udp.begin(localPort);
  delay(200);
}

void loop() {
 
//**************** Send to server**********************************************************
    Udp.beginPacket(ipServer,3000);
    Udp.write("Hello");
    Udp.endPacket();
    delay(10); 
 
//***************** Receive from server ****************************************************
  int packetSize = Udp.parsePacket();
  if (packetSize)
  {
    // receive incoming UDP packets
    Serial.printf("Received %d bytes from %s, port %d\n", packetSize, Udp.remoteIP().toString().c_str(), Udp.remotePort());
    int len = Udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    Serial.printf("UDP packet contents: %s\n", incomingPacket);

    // send back a reply, to the IP address and port we got the packet from
    Udp.beginPacket(Udp.remoteIP(), Udp.remotePort());
    Udp.write(replyPacekt);
    Udp.endPacket();
  }

delay(2);
}
