#include <Servo.h>

int sensor = A0;

Servo servo;

void setup() {
  pinMode(sensor, INPUT);
  servo.attach(9);
  Serial.begin(9600);
}

void loop() {
  // Rain = 0, No Rain = 1023
  int value = analogRead(sensor);
  
  if(value > 511) {
    servo.write(180);
  } else {
    servo.write(0);
  }

  delay(100);
}
