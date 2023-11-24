int RED = 6;
int GREEN = 10;
int BLUE = 9;

bool invertColor = true;

void setup() {
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
  Serial.begin(9600);
}

void digitalLed(int LED, int value) {
  if(invertColor) {
    digitalWrite(LED, 1 - value);
  } else {
    digitalWrite(LED, value);
  }
}

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
  color(0,0,0);
  digitalLed(RED, 1);
  delay(1000);
  color(0,0,0);
  digitalLed(BLUE, 1);
  delay(1000);
  color(0,0,0);
  digitalLed(GREEN, 1);
  delay(1000);
  color(255, 255, 255);
  delay(1000);
}
