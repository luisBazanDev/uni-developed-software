#include <Servo.h>

int LED1 = 2;
int LED2 = 3;

Servo servo;

void setup() {
  servo.attach(9);
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int value = analogRead(A0);
  Serial.println(value);

  delay(100);

  if(value > 600) {
    // Sin agua
    digitalWrite(LED1, 0);
    digitalWrite(LED2, 0);
    servo.write(0);
  } else {
    // Con agua
    digitalWrite(LED1, 1);
    digitalWrite(LED2, 1);
    servo.write(180);
  }
}
