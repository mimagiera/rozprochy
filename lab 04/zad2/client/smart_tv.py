import sys

from common_actions import common_actions_dict

sys.path.insert(1, '../generated_python')
import SmartHouseModule


def change_channel(device_prx):
    try:
        channel_nr = input("Enter channel nr: ")
        device_prx.changeChannel(channelNr=int(channel_nr))
        print("Channel changed")
    except SmartHouseModule.RangeError as e:
        print("Invalid range: " + str(e))


def get_current_channel(device_prx):
    print(device_prx.getCurrentChannel())


tv_actions = {**common_actions_dict, **{
    "change_channel": change_channel,
    "get_current_channel": get_current_channel
}}
