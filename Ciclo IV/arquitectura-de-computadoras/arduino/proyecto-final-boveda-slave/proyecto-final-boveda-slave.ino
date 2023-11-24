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
char temppass[4] = {'0', '0', '0', '0'};
int indexPass = 0;
int i = 0;
bool accessVault = false;
bool lockedState = false;
int maxTimeToChangePassword = 30; // seconds
long passchangeLimit = 0;

// Master serial
SoftwareSerial master(2,3);

// Object Keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPin, colPin, rows, cols);

void setup() {
  // Debug serial
  Serial.begin(9600);
  
  // Master serial
  master.begin(9600);
  delay(100);
  master.println("S"); // Syncronize access status
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
  while(master.available()) {
    rawCmd = master.readString();
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
        accessVault = true;
        Serial.println("Access");
      } else {
        accessVault = false;
        Serial.println("Deny");
      }
      if(rawCmd[4] == '1') {
        lockedState = true;
        Serial.println("Locked");
      } else {
        lockedState = false;
        Serial.println("Unlocked");
      }
      break;
  }
}

void keypadLogic() {
  char keypressed = keypad.getKey();

  if(lockedState && millis() > passchangeLimit) {
    // Timeout
    master.println("U");
    indexPass = 0;
    return;
  }

  if (keypressed != NO_KEY){
    master.println("K");

    if(lockedState) {
      temppass[indexPass] = keypressed;
      indexPass++;
      if(indexPass == 4) {
        indexPass = 0;
        for(i = 0; i < 4; i++) {
          password[i] = temppass[i];
        }
        
        Serial.println("New password");
        master.println("P");
      }
      return;
    }
    
    if(accessVault) {
      // If loged user
      switch(keypressed) {
        case '*':
          // Logout logic
          master.println("D");
          break;
        case '#':
          // Change password logic
          indexPass = 0;
          passchangeLimit = millis() + (maxTimeToChangePassword * 1000);
          master.println("B");
          break;
      }
      return;
    }

    // Password logic
    if(indexPass == 0) {
      Serial.println("Current password:");
    }

    // Print password
    Serial.print(keypressed);
    temppass[indexPass] = keypressed;
    indexPass++;
    
    // Complete password
    if(indexPass == 4) {
      indexPass = 0;
      Serial.println();
      // Check passwords
      if(comparePassword(password, temppass)) {
        // Access
        master.println("A");
      } else {
        // Don't access
        master.println("E");
      }
    }
  }
}

void loop() {
  masterLogic();
  keypadLogic();
}
