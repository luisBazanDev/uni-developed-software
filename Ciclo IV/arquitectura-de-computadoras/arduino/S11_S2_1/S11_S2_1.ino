#include <Servo.h>

long lastServo1 = 0;

long frame = 1;
long maxFrames = 2;
bool manual = true;

int LEDS[] = {8,9,10,11,12,13};

Servo head_servo;
Servo l_hand_servo;
Servo r_hand_servo;

int L_HAND = 1;
int R_HAND = 2;
int HEAD = 3;

void moveServo(int part, int deg) {
  switch (part) {
    case 1:
      l_hand_servo.write(deg);
      break;
    case 2:
      r_hand_servo.write(deg);
      break;
    case 3:
      head_servo.write(deg);
      break;
  }
}

void setup() {
  // put your setup code here, to run once:
  head_servo.attach(3);
  l_hand_servo.attach(5);
  r_hand_servo.attach(6);

  for(int i=0; i<6; i++) {
    pinMode(LEDS[i], OUTPUT);
  }
}

void loop() {
  animation();
  if(digitalRead(2) == 0) {
    manual = !manual;
    delay(300);
  }

  if(manual){
    // manual
  } else {
    
  }
}

long lastFrameTick = 0;
long nextFrame = 0;

void animation() {
  if(nextFrame > millis()) return;
  lastFrameTick = millis();
  nextFrame = lastFrameTick + 100;
  switch (frame) {
    case 1:
      pose1();
      break;
    case 10:
      pose2();
      break;
    case 15:
      pose3();
      break;
    case 17:
      pose1();
      break;
    case 20:
      pose3();
      break;
    case 23:
      pose1();
      break;
    case 26:
      pose3();
      break;
    case 29:
      pose1();
      break;
    case 30:
      pose4();
      break;
    case 31:
      pose5();
      break;
    case 32:
      pose4();
      break;
    case 33:
      pose5();
      break;
    case 34:
      pose4();
      break;
    case 35:
      pose5();
      break;
    case 36:
      pose4();
      break;
    case 37:
      pose5();
      break;
    case 38:
      pose4();
      break;
    case 39:
      pose5();
      break;
    case 40:
      pose4();
      break;
    case 41:
      pose5();
      break;
  }
  frame++;
}

void pose1() {
  // stay
  moveServo(HEAD, 90);
  moveServo(R_HAND, 90);
  moveServo(L_HAND, 90);
}

void pose2() {
  moveServo(HEAD, 120);
  moveServo(R_HAND, 45);
  moveServo(L_HAND, 135);
}

void pose3() {
  // great 1
  moveServo(HEAD, 90);
  moveServo(R_HAND, 45);
  moveServo(L_HAND, 90);
}

void pose4() {
  // uwu1
  moveServo(HEAD, 90);
  moveServo(R_HAND, 110);
  moveServo(L_HAND, 70);
}

void pose5() {
  // uwu2
  moveServo(HEAD, 90);
  moveServo(R_HAND, 120);
  moveServo(L_HAND, 60);
}