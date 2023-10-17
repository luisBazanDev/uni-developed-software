int Led1 = 9;
int Led2 = 5;

int selectedLed = Led1;

void setup() {
  pinMode(Led1, OUTPUT);
  pinMode(Led2, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // Select led
  if(Serial.available() == 0) return;
  char cmd = Serial.read();
  if(cmd == '1') {
    selectedLed = Led1;
    Serial.println("Selected led 1");
  } else if(cmd == '2') {
    selectedLed = Led2;
    Serial.println("Selected led 2");
  }
  if(cmd == 'h') {
    digitalWrite(selectedLed, HIGH);
    Serial.print("Led ");
    Serial.print(selectedLed);
    Serial.println(" set in HIGH");
  } else if(cmd == 'l') {
    digitalWrite(selectedLed, LOW);
    Serial.print("Led ");
    Serial.print(selectedLed);
    Serial.println(" set in LOW");
  }
}
