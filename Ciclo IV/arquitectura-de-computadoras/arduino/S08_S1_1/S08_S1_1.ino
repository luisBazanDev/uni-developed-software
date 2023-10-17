int Led1 = 9;
int Led2 = 5;

long tickLed1 = 0;
long tickLed2 = 0;

bool estadoLed1 = false;
bool estadoLed2 = false;

void setup() {
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // Led1
  if(tickLed1 <= millis()) {
    if(estadoLed1) {
      Serial.println("Led1 encendido!");
      digitalWrite(Led1, HIGH);
    } else {
      Serial.println("Led1 apagado :(");
      digitalWrite(Led1, LOW);
    }
    tickLed1 += 1000;
    estadoLed1 = !estadoLed1;
  }
  // Led2
  if(tickLed2 <= millis()) {
    if(estadoLed2) {
      Serial.println("Led1 encendido!");
      digitalWrite(Led2, HIGH);
    } else {
      Serial.println("Led1 apagado :(");
      digitalWrite(Led2, LOW);
    }
    tickLed2 += 500;
    estadoLed2 = !estadoLed2;
  }
}
