void setup() {
  pinMode(35, INPUT);
  Serial.begin(115200);
}

void loop() {
  int value = digitalRead(35);
  if(value == 1) {
    Serial.println("No pulsado");
  } else {
    Serial.println("Pulsado");
  }
  delay(200);
}
