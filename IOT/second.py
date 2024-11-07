import Adafruit_DHT
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
sensor = Adafruit_DHT.DHT11
pin = 12 # write ur pin

while True:
    humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
    if humidity > 0 and temperature > 0:
        print(f"temp: {temperature} , humidity: {humidity}")
    else:
        print("Invalid readings!")

    time.sleep(1)