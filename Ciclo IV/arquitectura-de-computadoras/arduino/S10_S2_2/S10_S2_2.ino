int LED_RED = 3;
int LED_BLUE = 5;
int LED_GREEN = 6;
int BUTTON1 = 7;
int BUTTON2 = 2;

bool encendidas = false;
long lastEncendido = 0;
int secuencia = 0;

void setup() {
  pinMode(LED_RED, OUTPUT);
  pinMode(LED_BLUE, OUTPUT);
  pinMode(LED_GREEN, OUTPUT);
  pinMode(BUTTON1, INPUT);
  pinMode(BUTTON2, INPUT);
  Serial.begin(9600);
}

void encenderLeds() {
  digitalWrite(LED_RED, 1);
  digitalWrite(LED_BLUE, 1);
  digitalWrite(LED_GREEN, 1);
}

void apagarLeds() {
  digitalWrite(LED_RED, 0);
  digitalWrite(LED_BLUE, 0);
  digitalWrite(LED_GREEN, 0);
}

void loop() {
  int btn_value = digitalRead(BUTTON1);
  if(btn_value == 1) {
    Serial.println("Luces listas");
    encendidas = true;
    delay(300);
  }

  btn_value = digitalRead(BUTTON2);
  if(btn_value == 1) {
    apagarLeds();
    Serial.println("Luces apagadas");
    encendidas = false;
    delay(300);
  }

  if(encendidas) {
    if(lastEncendido > millis() - 100) return;
    lastEncendido = millis();
    if(secuencia == 0) {
      encenderLeds();
      secuencia = 1;
    } else {
      apagarLeds();
      secuencia = 0;
    }
  }
}
