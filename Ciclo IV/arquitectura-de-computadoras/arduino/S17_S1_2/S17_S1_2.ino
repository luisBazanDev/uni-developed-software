void setup() {
  Serial.begin(9600);
}

void loop() {
  int estado = analogRead(A0);
  Serial.println(estado);
  delay(500);
}
