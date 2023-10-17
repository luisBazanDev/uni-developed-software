int BUTTON = 32;
int LEDS[4] = {2, 4, 5, 18};

int estado_btn;
int i;

void setup() {
  pinMode(BUTTON, INPUT);

  for(int i=0; i<4; i++) {
    pinMode(LEDS[i], OUTPUT);
  }

  Serial.begin(115200);
}

long nextFrame = 0;
int indexLed = 0;

void secuencia() {
  if(millis() < nextFrame) return;
  nextFrame = millis() + 200;
  if(indexLed == 4) {
    indexLed = 0;
    for(i=0; i<4; i++) {
      digitalWrite(LEDS[i], 0);
    }
    return;
  }
  Serial.println(indexLed);
  digitalWrite(LEDS[indexLed], 1);
  indexLed++;
}

void loop() {
  estado_btn = digitalRead(BUTTON);

  if(estado_btn == LOW) {
    secuencia();
  }
}
