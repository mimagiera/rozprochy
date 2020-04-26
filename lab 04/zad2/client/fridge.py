import sys

from common_actions import common_actions_dict

sys.path.insert(1, '../generated_python')
import SmartHouseModule


def set_temperature(device_prx):
    temp = input("Enter temperature: ")
    try:
        device_prx.setTemperature(temperature=int(temp))
        print("Temperature set")
    except SmartHouseModule.RangeError as e:
        print("Invalid range: " + str(e))


def get_temperature(device_prx):
    print(device_prx.getTemperature())


fridge_actions = {**common_actions_dict, **{
    "set_temperature": set_temperature,
    "get_temperature": get_temperature
}}
