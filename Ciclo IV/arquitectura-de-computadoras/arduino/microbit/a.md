# Arquitectura de computadoras
## Micro-bit
- Valores analogicos 0 a 1023
- Solo el pin 0 es analogico
## Iconos
```python
icons = [
  IconNames.ANGRY,
  IconNames.ASLEEP,
  IconNames.CONFUSED,
  IconNames.HAPPY,
  IconNames.HEART,
  IconNames.NO,
  IconNames.SAD,
  IconNames.SQUARE,
  IconNames.SWORD,
  IconNames.UMBRELLA,
  IconNames.YES
]

basic.show_icon(icons[2])
```

## Forever
```python
def onForever():
	basic.string("Forever print this.")

basic.forever(on_forever)
```

## Buttons
```python
def buttonA():
	basic.string("A")

def buttonB():
	basic.string("B")

input.on_button_pressed(Button.A, buttonA)
input.on_button_pressed(Button.B, buttonB)
```

## Digital write
```python
# DigitalPin. P0, P1, P2, P3
# Status OFF = 0, ON = 1
pins.digital_write_pin(DigitalPin.P0, 1)
```

## Analog read
```python
# DigitalPin. P0
pins.analog_read_pin(DigitalPin.P0)
```