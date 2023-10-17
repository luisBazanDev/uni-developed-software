int BUTTON1 = 32;
int BUTTON2 = 35;
int LED = 18;

void setup() {
  pinMode(BUTTON1, INPUT);
  pinMode(BUTTON2, INPUT);
  pinMode(LED, OUTPUT);

  Serial.begin(115200);
}

void loop() {
  int btn1 = digitalRead(BUTTON1);
  int btn2 = digitalRead(BUTTON2);

  if(btn1 == 1) {
  digitalWrite(LED, 0);
  }
  if(btn2 == 1) {
  digitalWrite(LED, 1);
  }
}
