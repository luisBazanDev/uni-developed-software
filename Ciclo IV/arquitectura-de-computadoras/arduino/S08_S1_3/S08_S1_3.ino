void setup() {
  Serial.begin(9600);
}

void loop() {
  int valuePot = analogRead(A0);
  Serial.println(valuePot);
}
