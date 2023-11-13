#include <Key.h>
#include <Keypad.h>
#include <SoftwareSerial.h>

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
byte rowPin[rows] = {4,5,6,7};
byte colPin[cols] = {8,9,10,11};

// Program variables
char password[4] = {'1', '2', '3', '4'};
char temppass[4] = {};
int index = 0;
int i = 0;
bool access = false;

// Master serial
SoftwareSerial master(22,24);

// Object Keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPin, colPin, rows, cols);

void setup() {
  // Debug serial
  Serial.begin(9600);
  
  // Master serial
  Serial3.begin(9600);
  delay(100);
  Serial3.println("S"); // Syncronize access status
}

bool comparePassword(char pass1[4], char pass2[4]) {
  for(int i = 0; i < 4; i++) {
    if(pass1[i] != pass2[i])
      return false;
  }
  return true;
}

void masterLogic() {
  // Initial variables
  String rawCmd = "";
  char symbol;

  // read rawCmd
  while(Serial3.available()) {
    rawCmd = Serial3.readString();
  }

  if(rawCmd.equals("")) return;
  
  // Check commands
  checkCmd(rawCmd[0], rawCmd);
}

// Execute command
void checkCmd(char cmd, String rawCmd) {
  switch (cmd) {
    case 'S':
      if(rawCmd[2] == '1') {
        access = true;
      } else {
        access = false;
      }
      break;
  }
}

void keypadLogic() {
  char keypressed = keypad.getKey();
  if (keypressed != NO_KEY){
    Serial3.println("K");

    if(access) {
      // If loged user
      switch(keypressed) {
        case '*':
          // Logout logic
          Serial3.println("D");
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
        Serial3.println("A");
      } else {
        // Don't access
        Serial3.println("E");
      }
    }
  }
}

void loop() {
  masterLogic();
  keypadLogic();

  // Test
  if(Serial.available()) {
    char a = Serial.read();
    Serial3.print(a);
  }
}
