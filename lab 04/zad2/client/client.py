import sys

import Ice
from fridge import fridge_actions
from smart_tv import tv_actions
from thermometer import thermometer_actions

sys.path.insert(1, '../generated_python')
import SmartHouseModule

name_to_proxy_string = {
    "veryGoodTv": "smartTv/veryGoodTv",
    "veryBadTv": "smartTv/veryBadTv",
    "basicFridge": "fridge/basicFridge",
    "basicThermometer": "thermometer/basicThermometer"
}


def get_proxy_string_from_name(name):
    return name_to_proxy_string.get(name) + ":tcp -h localhost -p 10000"


def get_proxy_from_name(name):
    return communicator.stringToProxy(get_proxy_string_from_name(name))


def get_functions_for_device(device):
    device_type = type(device)
    if device_type == SmartHouseModule.SmartTvPrx:
        return tv_actions
    if device_type == SmartHouseModule.FridgePrx:
        return fridge_actions
    if device_type == SmartHouseModule.ThermometerPrx:
        return thermometer_actions


with Ice.initialize(sys.argv) as communicator:
    veryGoodTv = SmartHouseModule.SmartTvPrx.checkedCast(get_proxy_from_name("veryGoodTv"))
    veryBadTv = SmartHouseModule.SmartTvPrx.checkedCast(get_proxy_from_name("veryBadTv"))
    basicFridge = SmartHouseModule.FridgePrx.checkedCast(get_proxy_from_name("basicFridge"))
    basicThermometer = SmartHouseModule.ThermometerPrx.checkedCast(get_proxy_from_name("basicThermometer"))
    if not veryGoodTv:
        raise RuntimeError("Invalid proxy for veryGoodTv")
    if not veryBadTv:
        raise RuntimeError("Invalid proxy for veryBadTv")
    if not basicFridge:
        raise RuntimeError("Invalid proxy for basicFridge")
    if not basicThermometer:
        raise RuntimeError("Invalid proxy for basicThermometer")

    name_to_proxy = {
        "veryGoodTv": veryGoodTv,
        "veryBadTv": veryBadTv,
        "basicFridge": basicFridge,
        "basicThermometer": basicThermometer
    }

    print("Possible devices: veryGoodTv, veryBadTv, basicFridge, basicThermometer")
    program_is_working = True
    while program_is_working:
        device_name = input("Enter device name or \"exit\" to exit: ")
        device = name_to_proxy.get(device_name)
        device_is_selected = True
        if device is not None:
            functions = get_functions_for_device(device)
            while device_is_selected:
                function_name = input("Choose device operation or \"change\" to change something. Possible are " + str(
                    functions.keys()) + " ")
                function = functions.get(function_name)
                if function is not None:
                    function(device)
                if function_name == "change":
                    device_is_selected = False
        elif device_name == "exit":
            program_is_working = False
        else:
            print("Invalid device name")
