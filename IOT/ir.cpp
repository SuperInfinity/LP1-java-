int ir = 3; // take ur pin
int led = 4; // take ur pin

void setup {
    pinMode(ir, INPUT);
    pinMode(led, OUTPUT);
}

void loop() {
    int data = digitalRead(ir);
    if (data == LOW) {
        digitalWrite(led, HIGH);
    }
    else {
        digitalWrite(LED, LOW);
    }
}