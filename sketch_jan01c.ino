#include <SoftwareSerial.h>
#include <ArduinoJson.h>
#include <SerialCommand.h>
//Code By ArduinoALL

SoftwareSerial ArduinoSerial(3, 2); // RX, TX
void setup() {
Serial.begin(115200);
ArduinoSerial.begin(4800);
}


void loop() {
  while(ArduinoSerial.available()>0){
    char value = ArduinoSerial.read();
    Serial.print(value);
  }
}


