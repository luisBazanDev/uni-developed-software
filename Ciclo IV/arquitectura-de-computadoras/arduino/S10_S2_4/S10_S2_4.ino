int LED = 6;
int LDR = A0;

void setup() {
  pinMode(LED, OUTPUT);
  pinMode(LDR, INPUT);
  Serial.begin(9600);
}

void loop() {
  int value = analogRead(LDR);
  Serial.println(value);
  if(value > 600) {
    digitalWrite(LED, 0);
  } else {
    digitalWrite(LED, 1);
  }
  delay(100);
}
