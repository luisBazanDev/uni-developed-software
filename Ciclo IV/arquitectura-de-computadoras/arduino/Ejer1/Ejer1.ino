int LEDS[] = {19, 18, 4, 21};
int i = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  for(i = 0; i < sizeof(LEDS); i++) {
    pinMode(LEDS[i], OUTPUT);
  }
}

void loop() {
  uea();
}

void uea() {
  for(i = 0; i < 4; i++) {
    digitalWrite(LEDS[i], 1);
    delay(500);
    digitalWrite(LEDS[i], 0);
  }
}