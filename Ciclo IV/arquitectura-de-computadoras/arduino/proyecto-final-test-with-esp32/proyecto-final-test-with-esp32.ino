#include <SoftwareSerial.h>
EspSoftwareSerial::UART otherSerial;

char symbol;

void setup() {
  Serial.begin(115200);
  otherSerial.begin(9600, SWSERIAL_8N1, 33, 32);
}

void loop() {
  if(Serial.available()) {
    symbol = Serial.read();
    otherSerial.print(symbol);
  }

  if(otherSerial.available()) {
    symbol = otherSerial.read();
    Serial.print(symbol);
  }

}
