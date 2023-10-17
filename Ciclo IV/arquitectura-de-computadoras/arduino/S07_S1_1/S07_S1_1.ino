int LEDS[3] = {33, 32, 27};
int POT = 34;

int value = 0;

void setup() {
  pinMode(POT, INPUT);
  for(int i = 0; i < 3; i++) {
    pinMode(LEDS[i], OUTPUT);
  }
  Serial.begin(115200);
}

void loop() {
  value = analogRead(POT);
  Serial.println(value);
  if(value < 100) {
    digitalWrite(LEDS[0], 0);
    digitalWrite(LEDS[1], 0);
    digitalWrite(LEDS[2], 0);
  } else if (value < 500) {
    digitalWrite(LEDS[0], 1);
    digitalWrite(LEDS[1], 0);
    digitalWrite(LEDS[2], 0);
  } else if(value < 1000) {
    digitalWrite(LEDS[0], 1);
    digitalWrite(LEDS[1], 1);
    digitalWrite(LEDS[2], 0);
  } else {
    digitalWrite(LEDS[0], 1);
    digitalWrite(LEDS[1], 1);
    digitalWrite(LEDS[2], 1);
  }
  delay(100);
}
