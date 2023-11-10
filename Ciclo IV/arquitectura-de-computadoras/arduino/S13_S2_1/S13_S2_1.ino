#include <SoftwareSerial.h>

SoftwareSerial serial1(4,3);

char estado;

void setup() {
  pinMode(12, OUTPUT);
  Serial.begin(9600);
  serial1.begin(9600);
  for(int i = 0; i < 50; i++) {
    serial1.println("");
  }
  serial1.println("Conectado");
  Serial.println("Conectado");
}

void loop() {
  if(serial1.available()) {
    estado = serial1.read();
    Serial.print(estado);
    switch (estado) {
      case '1':
        digitalWrite(12, 0);
        serial1.println(estado);
        delay(100);
        break;
      case '2':
        digitalWrite(12, 1);
        serial1.println(estado);
        delay(100);
        break;
    }
  }
}
