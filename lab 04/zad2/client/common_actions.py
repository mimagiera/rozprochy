def turn_on(device_prx):
    print(device_prx.turnOn())


def turn_off(device_prx):
    print(device_prx.turnOff())


def get_name(device_prx):
    print(device_prx.getName())


def get_status(device_prx):
    status = device_prx.getStatus()
    if status:
        print("up")
    else:
        print("down")


common_actions_dict = {
    'turn_on': turn_on,
    'turn_off': turn_off,
    'get_name': get_name,
    'get_status': get_status
}