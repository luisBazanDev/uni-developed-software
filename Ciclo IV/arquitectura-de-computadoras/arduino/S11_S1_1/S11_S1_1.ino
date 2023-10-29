#include <Servo.h>

Servo servo;
int POT = A0;
int angle = 0;

void setup() {
  pinMode(POT, INPUT);
  servo.attach(5);
  Serial.begin(9600);
}

void loop() {
  int servo_angle = map(analogRead(POT), 0, 1023, 0, 180);
  Serial.println(servo_angle);
  if(angle != servo_angle) {
    if (servo_angle - angle <= 5 && servo_angle - angle >= -5) return;
    Serial.println("Move!");
    angle = servo_angle;
    servo.write(angle);
  }
}
