const int umbral;
int LDR = A0;
int LED = 3;

int value;
int i;

void setup() {
  pinMode(LDR, INPUT);
  pinMode(LED, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  value = analogRead(LDR);

  if(value < 500) {
    digitalWrite(LED, 1);
  } else {
    digitalWrite(LED, 0);
  }

  graphValue(value-200, 7);
  delay(50);
}

void graphValue(int value, int scale) {
  for(i = 0; i < value / scale; i++) {
    Serial.print("|");
  }
  Serial.println();
}
