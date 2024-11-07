import requests
import Adafruit_DHT as ada
import time
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)

sensor = Adafruit_DHT.DHT11
pin = 4 # write ur pin

writekey = "HE0ZTTE32KS6B2GQ" # paste ur code
apilink = f"https://api.thingspeak.com/update?api_key={writekey}"

while True:
    hum, temp = ada.read_retry(sensor, pin)
    if hum > 0 and temp > 0:
        print(f"temp: {temp}, hum: {hum}")
        x = f"{apilink}&field1={hum}&field2={temp}"
        y = requests.post(x)
        print(y.status_code)
        print(x)
    else:
        print("Invalid readings!")

    time.sleep(2)