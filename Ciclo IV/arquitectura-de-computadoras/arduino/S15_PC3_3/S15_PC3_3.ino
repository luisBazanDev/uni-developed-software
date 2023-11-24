int RED = 12;
int GREEN = 14;
int BLUE = 27;

bool invertColor = true;

void setup() {
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
  Serial.begin(115200);
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
  while(Serial.available() > 0) {
    int red = Serial.parseInt();;
    int green = Serial.parseInt();;
    int blue = Serial.parseInt();;

    if(Serial.read() == '\n') {
      color(
        constrain(red, 0, 255),
        constrain(green, 0, 255),
        constrain(blue, 0, 255)
      );
      Serial.print("Color parser #");
      Serial.print(red, HEX);
      Serial.print(green, HEX);
      Serial.print(blue, HEX);
      Serial.println();
      delay(100);
    }
  }
}
