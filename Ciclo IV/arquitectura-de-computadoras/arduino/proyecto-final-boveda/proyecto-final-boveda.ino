// Ideas
/*
- RFID
- Buzzer
- Led rojo y verde
- KeyPad
- Forma de cambiar la contraseña base
- Servomotor para el movimiento libre
- Usar un arduino UNO(Modulo RFID) comunicado por serial
- Usar un arduino UNO(Principal, con el keypad, leds)
- Encriptacion en la comunicacion serie :u
*/
#include <SPI.h>
#include <MFRC522.h>
#include <SoftwareSerial.h>
#include <Servo.h>

#define RST_PIN 9
#define SS_PIN 10

// Vault system
bool vault_state = false;
bool access = false;
bool blockingState = false;
SoftwareSerial slave(2, 3);

// RFID
MFRC522 rfid(SS_PIN, RST_PIN);
byte rfid_access[4] = { 137, 3, 28, 135 };

// Buzzer
int buzzerPin = 4;
long lastTones = 0;
long buzzFrame = 0;
int toneID = 0;

// Servo
Servo servo;
int servoPin = 5;

// Leds
int RED_LED = 7;
int GREEN_LED = 6;

void setup() {
  // Serial comunication
  pinMode(2, INPUT);
  pinMode(3, OUTPUT);
  Serial.begin(9600);
  slave.begin(9600);
  while (!Serial);

  // Setup pins and objects
  SPI.begin();
  rfid.PCD_Init();
  delay(4);
  rfid.PCD_DumpVersionToSerial();
  Serial.println(F("Scan PICC to see UID, SAK, type, and data blocks..."));

  // Buzzer
  pinMode(buzzerPin, OUTPUT);

  // Servo
  servo.attach(servoPin);
  closeDoor();

  // Leds
  pinMode(RED_LED, OUTPUT);
  pinMode(GREEN_LED, OUTPUT);
}

void slaveLogic() {
  // Initial variables
  String rawCmd = "";
  char symbol;

  // read rawCmd
  while(slave.available()) {
    symbol = slave.read();
    if(symbol == '\n') break;
    rawCmd += String(symbol);
  }

  if(rawCmd.equals("")) return;
  
  // Check commands
  checkCmd(rawCmd[0], rawCmd);
}

void rfidLogic() {
  // RFID logic
  if(blockingState) return;
  if(!rfid.PICC_IsNewCardPresent()) return;
  if(!rfid.PICC_ReadCardSerial()) return;

  // Valid access
  for (byte i = 0; i < 4; i++) {
    if(rfid.uid.uidByte[i] != rfid_access[i]) {
      // Deny access
      checkCmd('E', "");
      rfid.PICC_HaltA();
      return;
    }
  }
  // Grand access
  if(access) {
    checkCmd('D', "");
  } else {
    checkCmd('A', "");
  }
  rfid.PICC_HaltA();
}

void ledsLogic() {
  if(access) {
    digitalWrite(RED_LED, LOW);
    digitalWrite(GREEN_LED, HIGH);
  } else {
    digitalWrite(RED_LED, HIGH);
    digitalWrite(GREEN_LED, LOW );
  }
}

// Execute command
void checkCmd(char cmd, String rawCmd) {
  switch (cmd) {
    case 'S': // Sync access state
      sendSyncCmd();
      break;
    case 'A': // Grant access
      access = true;
      toneID = 2;
      sendSyncCmd();
      openDoor();
      break;
    case 'D': // revoke access
      access = false;
      toneID = 3;
      sendSyncCmd();
      closeDoor();
      break;
    case 'E': // Any error
      toneID = 1;
      break;
    case 'K': // Key press
      toneID = 4;
      break;
    case 'B': // Locked state
      toneID = 5;
      blockingState = true;
      sendSyncCmd();
      break;
    case 'U': // Unlocked state
      toneID = 0;
      blockingState = false;
      sendSyncCmd();
      break;
    case 'P': // New password
      toneID = 6;
      blockingState = false;
      sendSyncCmd();
      break;
  }
}

void openDoor() {
  servo.write(90);
  Serial.println("Open Door");
  vault_state = true;
}

void closeDoor() {
  servo.write(0);
  Serial.println("Close Door");
  vault_state = false;
}

void loop() {
  // Run loop
  rfidLogic();
  slaveLogic();
  ledsLogic();
  toneTick();
}

void sendSyncCmd() {
  slave.print("S:");
  slave.print(access);
  slave.print(":");
  slave.print(blockingState);
  slave.println();
}

void toneTick() {
  if(millis() - lastTones < 100) return;
  lastTones = millis();
  switch(toneID) {
    case 0:
      buzzFrame = 0;
      noTone(buzzerPin);
      break;
    case 1: // Error
      if(buzzFrame % 2 == 0) {
        tone(buzzerPin, 1000);
      } else {
        noTone(buzzerPin);
      }
      
      if(buzzFrame >= 6) toneID = 0;

      buzzFrame++;
      break;
    case 2: // Login
      switch(buzzFrame) {
        case 0:
          tone(buzzerPin, 300);
          break;
        case 1:
          tone(buzzerPin, 1500);
          break;
        default:
          toneID = 0;
          break;
      }

      buzzFrame++;
      break;
    case 3: // Logout
      switch(buzzFrame) {
        case 0:
          tone(buzzerPin, 1500);
          break;
        case 1:
          tone(buzzerPin, 500);
          break;
        case 2:
          tone(buzzerPin, 400);
          break;
        case 3:
          tone(buzzerPin, 300);
          break;
        default:
          toneID = 0;
          break;
      }

      buzzFrame++;
      break;
    case 4: // Keypad
      tone(buzzerPin, 750);
      if(blockingState) {
        toneID = 5;
      } else {
        toneID = 0;
      }
      break;
    case 5: // Bloking state
      switch (buzzFrame) {
        case 1:
          tone(buzzerPin, 550);
          break;
        case 5:
          buzzFrame = 0;
          break;
        default:
          noTone(buzzerPin);
          break;
      }
      buzzFrame++;
      break;
    case 6: // Password changed
      switch(buzzFrame) {
        case 1:
          tone(buzzerPin, 1000);
          break;
        case 3:
          tone(buzzerPin, 500);
          break;
        case 5:
          tone(buzzerPin, 2500);
          break;
        case 6:
          tone(buzzerPin, 2000);
          break;
        case 7:
          toneID = 0;
          break;
      }
      buzzFrame++;
      break;
  }
}