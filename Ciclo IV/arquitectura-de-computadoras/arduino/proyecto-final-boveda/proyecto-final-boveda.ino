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
SoftwareSerial slave(2, 3);

// RFID
MFRC522 rfid(SS_PIN, RST_PIN);
byte rfid_access[4] = { 137, 3, 28, 135 };

// Buzzer
int buzzerPin = 4;
long lastTones = 0;
int buzzFrame = 0;
int toneID = 0;

// Servo
Servo servo;
int servoPin = 5;

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

// Execute command
void checkCmd(char cmd, String rawCmd) {
  switch (cmd) {
    case 'S':
      slave.print("S:");
      slave.println(access);
      break;
    case 'A':
      // grant access
      access = true;
      toneID = 2;
      slave.print("S:");
      slave.println(access);
      openDoor();
      break;
    case 'D':
      // revoke access
      access = false;
      toneID = 3;
      slave.print("S:");
      slave.println(access);
      closeDoor();
      break;
    case 'E':
      toneID = 1;
      break;
    case 'K':
      toneID = 4;
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
  toneTick();
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
      toneID = 0;
      break;
  }
}