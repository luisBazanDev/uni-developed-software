int ledPin = 3;
bool ledState = false;

void setup() {
  pinMode(2, INPUT);
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int estado = digitalRead(2);
  Serial.println(estado);
  if(estado == 1) {
    // Sonido
    ledState = !ledState;
    Serial.println(ledState);
    delay(500);
  }

  if(ledState) {
    digitalWrite(ledPin, 1);
  } else {
    digitalWrite(ledPin, 0);
  }
}
