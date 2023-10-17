int BUTTON1 = 35;
int BUTTON2 = 32;
int LED = 33;

int status1, status2;
bool conTapa = false;
int statusBotella = 0;

void setup() {
  pinMode(BUTTON1, INPUT);
  pinMode(BUTTON2, INPUT);
  pinMode(LED, OUTPUT);
  
  Serial.begin(115200);
}

void blinkLed() {
  digitalWrite(LED, 1);
  delay(300);
  digitalWrite(LED, 0);
}

void onBtn1() {
  if(statusBotella == 0) {
    Serial.println("Gaseosa llena");
    delay(300);
    statusBotella = 1;
    blinkLed();
    return;
  }
  if(statusBotella == 1 && conTapa) {
    Serial.println("Gaseosa bien empaquetada");
    digitalWrite(LED, 1);
    statusBotella = 2;
    delay(300);
  } else {
    if(statusBotella != 1) return;
    Serial.println("¡Falta colocar la tapa!");
    delay(300);
  }
}

void onBtn2() {
  Serial.println("Gaseosa tapada");
  delay(1000);
  Serial.println("Gaseosa bien tapada");
  digitalWrite(LED, 1);
  return;
  if(!conTapa) {
    Serial.println("Se puso la tapa");
  } else {
    Serial.println("Se quito la tapa");
  }
  conTapa = !conTapa;
  delay(300);
}

void loop() {
  status1 = digitalRead(BUTTON1);
  status2 = digitalRead(BUTTON2);
  
  if(status1 == 0) {
    onBtn1();
  }

  if(status2 == 0) {
    onBtn2();
  }
}
