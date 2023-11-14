int RED = 12;
int GREEN = 14;
int BLUE = 27;

bool invertColor = true; // ANODE = true | CATHODE = false

void setup() {
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
}

// If a other implementation of digitalWrite
void digitalLed(int LED, int value) {
  if(invertColor) {
    digitalWrite(LED, 1 - value);
  } else {
    digitalWrite(LED, value);
  }
}

// If a other implementation of analodWrite
void analogLed(int LED, int value) {
  if(invertColor) {
    analogWrite(LED, 255 - value);
  } else {
    analogWrite(LED, value);
  }
}

void color(int red_v, int green_v, int blue_v) {
  analogLed(RED, red_v);
  analogLed(GREEN, green_v);
  analogLed(BLUE, blue_v);
}

void loop() {
  color(255, 0, 255); // purple
  delay(1000);
  color(0, 255, 0); // green
  delay(1000);
  color(255, 0, 0); // red
  delay(1000);
}
