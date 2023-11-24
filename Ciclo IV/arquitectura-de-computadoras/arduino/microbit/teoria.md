## Keypad
*Referencia a [documentacion oficial](https://playground.arduino.cc/Code/Keypad/)*

Diagrama de conexión
![1699370827_grim.png](:/62b4598823024b13820860df3ee11c72)

## Sensor HC-SR04

```cpp
// Pines
int trigger = 2;
int echo = 3;

// Distance
long distance = 0;

void setup() {
  pinMode(trigger, OUTPUT);
  pinMode(echo, INPUT);
}

void loop() {
  // Logic of sensor HC-SR04
  digitalWrite(trigger, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigger, LOW);
  distance = pulseIn(echo, HIGH) * 0.017;
}
```

#include <Servo.h>