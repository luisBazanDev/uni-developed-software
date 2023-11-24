#include <Key.h>
#include <Keypad.h>
#include <Servo.h>

// number of rows and columns
const byte rows = 4;
const byte cols = 4;

// Chars in the keypad
char keys[rows][cols] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

// arduino pines9,8,7,6
byte rowPin[rows] = {2,3,4,5};
byte colPin[cols] = {6,7,8,9};

// Object Keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPin, colPin, rows, cols);
Servo servo;

void setup() {
  servo.attach(12);
  Serial.begin(9600);
}

void loop() {
  char keypressed = keypad.getKey();
  if (keypressed != NO_KEY){
    Serial.println(keypressed);
    switch(keypressed) {
      case '*':
        for(int i = 0; i < 180; i++) {
          servo.write(i);
          delay(10);
        }
        break;
      case '#':
        for(int i = 180; i > 0; i--) {
          servo.write(i);
          delay(10);
        }
        break;
    }
  }
}
