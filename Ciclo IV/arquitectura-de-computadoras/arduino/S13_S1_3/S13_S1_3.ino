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
byte LED_RED = 10;
byte LED_GREEN = 12;

// Object Keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPin, colPin, rows, cols);

// Program variables
char password[4] = {'1', '2', '3', '4'};
char temppass[4] = {};
int index = 0;
int i = 0;
bool access = false;

void setup() {
  Serial.begin(9600);
  pinMode(LED_RED, OUTPUT);
  pinMode(LED_GREEN, OUTPUT);
  digitalWrite(LED_RED, 1);
}

bool comparePassword(char pass1[4], char pass2[4]) {
  for(int i = 0; i < 4; i++) {
    if(pass1[i] != pass2[i])
      return false;
  }
  return true;
}

void loop() {
  char keypressed = keypad.getKey();
  if (keypressed != NO_KEY){

    if(access) {
      // If loged user
      switch(keypressed) {
        case '*':
          // Logout logic
          digitalWrite(LED_GREEN, 0);
          digitalWrite(LED_RED, 1);
          Serial.println("Logout");
          access = false;
          break;
      }
      return;
    }
    // Password logic
    if(index == 0) {
      Serial.println("Current password:");
    }

    // Print password
    Serial.print(keypressed);
    temppass[index] = keypressed;
    index++;
    
    // Complete password
    if(index == 4) {
      index = 0;
      Serial.println();
      // Check passwords
      if(comparePassword(password, temppass)) {
        // Access
        digitalWrite(LED_RED, 0);
        digitalWrite(LED_GREEN, 1);
        Serial.println("Access");
        access = true;
      } else {
        // Don't access
        Serial.println("Invalid password");
        digitalWrite(LED_RED, 0);
        delay(100);
        digitalWrite(LED_RED, 1);
        delay(100);
        digitalWrite(LED_RED, 0);
        delay(100);
        digitalWrite(LED_RED, 1);
      }
    }
  }
}
