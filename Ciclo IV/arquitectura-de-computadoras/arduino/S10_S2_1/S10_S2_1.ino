int LED_RED = 3;
int LED_BLUE = 5;
int LED_GREEN = 6;
int BUTTON = 2;

int indice = 0;

void setup() {
  pinMode(LED_RED, OUTPUT);
  pinMode(LED_BLUE, OUTPUT);
  pinMode(LED_GREEN, OUTPUT);
  pinMode(BUTTON, INPUT);
}

void loop() {
  int btn_value = digitalRead(BUTTON);

  if(btn_value == 1) {
    digitalWrite(LED_RED, 0);
    digitalWrite(LED_BLUE, 0);
    digitalWrite(LED_GREEN, 0);
    indice = 0;
    return;
  }

  if(indice == 0) {
    digitalWrite(LED_RED, 1);
    digitalWrite(LED_BLUE, 0);
    digitalWrite(LED_GREEN, 0);
    delay(200);
    indice++;
  } else if(indice == 1) {
    digitalWrite(LED_RED, 1);
    digitalWrite(LED_BLUE, 1);
    digitalWrite(LED_GREEN, 0);
    delay(200);
    indice++;
  } else if(indice == 2) {
    digitalWrite(LED_RED, 1);
    digitalWrite(LED_BLUE, 1);
    digitalWrite(LED_GREEN, 1);
    delay(200);
    indice++;
  } else {
    digitalWrite(LED_RED, 0);
    digitalWrite(LED_BLUE, 0);
    digitalWrite(LED_GREEN, 0);
    delay(200);
    indice = 0;
  }
}
