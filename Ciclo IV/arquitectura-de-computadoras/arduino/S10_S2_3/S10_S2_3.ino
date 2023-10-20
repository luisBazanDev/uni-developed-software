int LEDS[5] = {2,8,3,5,6};
int POT = A0;

int i = 0;

void setup() {
  for(i = 0; i < 5; i++) {
    pinMode(LEDS[i], OUTPUT);
  }
  pinMode(POT, INPUT);
  Serial.begin(9600);
}

void apagarLeds() {
  for(i = 0; i < 5; i++) {
    digitalWrite(LEDS[i], 0);
  }
}

void loop() {
  int value = analogRead(POT);
  int index = map(value, 0, 1023, 0, 4);
  apagarLeds();
  digitalWrite(LEDS[index], 1);
  delay(100);
}
