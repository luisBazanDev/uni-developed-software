int sensor = 9;

void setup() {
  pinMode(sensor, INPUT);
  Serial.begin(9600);
}

void loop() {
  // Rain = 0, No Rain = 1
  int value = digitalRead(sensor);
  Serial.println(value);

  if(value == 0) {
    Serial.println("Lluvia");
  } else {
    Serial.println("No hay lluvia");
  }

  delay(100);
}
