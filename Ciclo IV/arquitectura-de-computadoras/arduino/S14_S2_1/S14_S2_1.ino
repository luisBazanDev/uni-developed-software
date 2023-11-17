byte SALA_LED = 14;
byte BANO_LED = 27;
byte COCINA_LED = 26;
byte DORMITORIO_LED = 25;

void setup() {
  Serial.begin(115200);
  Serial2.begin(9600);
  pinMode(SALA_LED, OUTPUT);
  pinMode(BANO_LED, OUTPUT);
  pinMode(COCINA_LED, OUTPUT);
  pinMode(DORMITORIO_LED, OUTPUT);
}

void loop() {
  if (Serial.available()) {
    Serial2.write(Serial.read());
  }
  if (Serial2.available()) {
    char cmd = Serial2.read();
    Serial.print(cmd);
    switch (cmd) {
      case 'a':
        // sala on
        digitalWrite(SALA_LED, 1);
        break;
      case 'b':
        // sala off
        digitalWrite(SALA_LED, 0);
        break;
      case 'c':
        // baño on
        digitalWrite(BANO_LED, 1);
        break;
      case 'd':
        // baño off
        digitalWrite(BANO_LED, 0);
        break;
      case 'e':
        // cocina on
        digitalWrite(COCINA_LED, 1);
        break;
      case 'f':
        // cocina off
        digitalWrite(COCINA_LED, 0);
        break;
      case 'g':
        // dormitorio on
        digitalWrite(DORMITORIO_LED, 1);
        break;
      case 'h':
        // dormitorio off
        digitalWrite(DORMITORIO_LED, 0);
        break;
    }
    Serial.write(Serial2.read());
  }
  delay(20);
}
