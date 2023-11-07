#include <Key.h>
#include <Keypad.h>

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

// arduino pines
byte rowPin[rows] = {9,8,7,6};
byte colPin[cols] = {5,4,3,2};
byte LED1 = 13;

// Object Keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPin, colPin, rows, cols);

// Program variables

void setup() {
  Serial.begin(9600);
  pinMode(LED1, OUTPUT);
}

void loop() {
  char keypressed = keypad.getKey();
  if (keypressed != NO_KEY){
    // Print key status
    Serial.print("Presionaste la tecla: ");
    Serial.println(keypressed);

    // Led logic
    switch (keypressed) {
      case 'A':
        digitalWrite(LED1, 1);
        break;
      case 'D':
        digitalWrite(LED1, 0);
        break;
    }
  }
}
