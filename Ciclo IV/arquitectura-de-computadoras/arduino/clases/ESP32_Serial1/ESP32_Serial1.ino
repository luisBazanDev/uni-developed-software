
char character;

void setup() {
  Serial.begin(115200);
  Serial2.begin(9600);
}

void loop() {
  if(Serial.available()) {
    character = Serial.read();
    Serial2.print(character);
  }

  if(Serial2.available()) {
    character = Serial2.read();
    Serial.print(character);
  }
}
