void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  if(Serial.available() <= 0) return;
  char cmd = Serial.read();
  if(cmd == 'a') {
    Serial.println("Bienvenido UTP");
  }
  if(cmd == 'b') {
    Serial.println("Arquitectura de computadoras");
  }
  if(cmd == 'c') {
    Serial.println("Gracias por tu visita");
  }
}
