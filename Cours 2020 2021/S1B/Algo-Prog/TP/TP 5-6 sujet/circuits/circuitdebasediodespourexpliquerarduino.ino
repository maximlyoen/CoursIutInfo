//  _ ___ _______     ___ ___ ___  ___ _   _ ___ _____ ___
// / |_  )__ /   \   / __|_ _| _ \/ __| | | |_ _|_   _/ __|
// | |/ / |_ \ |) | | (__ | ||   / (__| |_| || |  | | \__ \ 
// |_/___|___/___/   \___|___|_|_\\___|\___/|___| |_| |___/
//
// circuit de base diodes (pour expliquer arduino)
//
// Made by journet nicholas
// License: CC-BY-SA 3.0
// Downloaded from: https://circuits.io/circuits/3623223-circuit-de-base-diodes-pour-expliquer-arduino

// Pin 13 has an LED connected on most Arduino boards.
// give it a name:
int led = 13;
int state;

// the setup routine runs once when you press reset:
void setup()
{
    Serial.begin(9600);
    // initialize the digital pin as an output.
    Serial.print("couddddcou");
    Serial.println();
    pinMode(3, OUTPUT);
    pinMode(4, OUTPUT);
    pinMode(5, OUTPUT);
    pinMode(2, INPUT);
}

// the loop routine runs over and over again forever:
void loop()
{
    Serial.print("AAAAA");// wait for a second
    Serial.println();

    Serial.println();
    state = digitalRead(2);
    if (state == HIGH) {
        digitalWrite(5, HIGH);
        digitalWrite(4, HIGH);
        digitalWrite(3, HIGH); // turn the LED on (HIGH is the voltage level)
        delay(1000);               // wait for a second
    } else {
        digitalWrite(5, LOW); // turn the LED off by making the voltage LOW
        digitalWrite(4, LOW);
        digitalWrite(3, LOW);
    }
    delay(1000);
}
