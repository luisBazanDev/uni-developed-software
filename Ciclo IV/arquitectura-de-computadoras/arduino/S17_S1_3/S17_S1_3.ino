int ledPin1 = 3;
int ledPin2 = 4;
int ledPin3 = 5;
int ledPin4 = 6;
int ledPin5 = 7;
bool ledState = false;

void setup() {
  pinMode(2, INPUT);
  pinMode(ledPin1, OUTPUT);
  pinMode(ledPin2, OUTPUT);
  pinMode(ledPin3, OUTPUT);
  pinMode(ledPin4, OUTPUT);
  pinMode(ledPin5, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int estado = digitalRead(2);
  Serial.println(estado);
  if(estado == 1) {
    // Sonido
    ledState = !ledState;
    Serial.println(ledState);
    delay(500);
  }

  if(ledState) {
    digitalWrite(ledPin1, 1);
    digitalWrite(ledPin2, 1);
    digitalWrite(ledPin3, 1);
    digitalWrite(ledPin4, 1);
    digitalWrite(ledPin5, 1);
  } else {
    digitalWrite(ledPin1, 0);
    digitalWrite(ledPin2, 0);
    digitalWrite(ledPin3, 0);
    digitalWrite(ledPin4, 0);
    digitalWrite(ledPin5, 0);
  }
}
