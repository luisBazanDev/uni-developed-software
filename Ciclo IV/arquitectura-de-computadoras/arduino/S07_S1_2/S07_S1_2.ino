#include <Servo.h>

int POT = A0;
Servo servo;
int value=0;

void setup() {
  servo.attach(9);
  pinMode(POT, INPUT);
}

void loop() {
  value = analogRead(POT);
  int angle = map(value, 0, 1023, 0, 180);
  servo.write(angle);
}
