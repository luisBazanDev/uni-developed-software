int sensor = A0;
int led1 = 11;

void setup() {
  pinMode(sensor, INPUT);
  pinMode(led1, OUPUT);
  Serial.begin(9600);
}

void loop() {
  // Rain = 0, No Rain = 1023
  int value = analogRead(sensor);

  int ledValue = 255 - map(value, 0, 1023, 0, 255);

  Serial.println(ledValue);

  analogWrite(led1, ledValue);

  delay(100);
}
