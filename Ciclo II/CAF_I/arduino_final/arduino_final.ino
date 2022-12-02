#include <Servo.h>
#include <CommandParser.h>
Servo servoAngle, servoGun;
typedef CommandParser<> MyCommandParser;
MyCommandParser parser;

String cmd, resp = "";
String args[] = {};
int angle = 0;
boolean pium;

void cmd_angle(MyCommandParser::Argument *args, char *response) {
  angle = args[0].asInt64;
  if(angle < 0 || angle > 180) {
    strlcpy(response, "Error angle", MyCommandParser::MAX_RESPONSE_SIZE);
    return;
  }
  servoAngle.write(angle);
  strlcpy(response, "Move angle", MyCommandParser::MAX_RESPONSE_SIZE);
}

void cmd_gun(MyCommandParser::Argument *args, char *response) {
  Serial.println("¡PIUM!");
  servoGun.write(0);
  delay(1500);
  servoGun.write(100);
  strlcpy(response, "Reset servo, waiting a charge...", MyCommandParser::MAX_RESPONSE_SIZE);
}

void setup() {
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  Serial.println("Commands:\nANGLE <0-180>\nGUN");

  parser.registerCommand("ANGLE", "i", &cmd_angle);
  parser.registerCommand("GUN", "", &cmd_gun);
  
  servoGun.attach(8);
  servoAngle.attach(9);
  servoGun.write(100);
}

void loop() {
  if (Serial.available()) {
    char line[128];
    size_t lineLength = Serial.readBytesUntil('\n', line, 127);
    line[lineLength] = '\0';

    char response[MyCommandParser::MAX_RESPONSE_SIZE];
    parser.processCommand(line, response);
    Serial.println(response);
  }
}
