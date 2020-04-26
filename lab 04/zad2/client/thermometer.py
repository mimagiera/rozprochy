from common_actions import common_actions_dict


def get_weather_states(device_prx):
    print(device_prx.getWeatherStates())


def get_temperature(device_prx):
    print(device_prx.getTemperature())


thermometer_actions = {**common_actions_dict, **{
    "get_weather_states": get_weather_states,
    "get_temperature": get_temperature
}}
