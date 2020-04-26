#ifndef SMART_HOUSE_ICE
#define SMART_HOUSE_ICE

module SmartHouseModule {

  interface SmartDevice {
   bool getStatus();
   bool turnOn();
   bool turnOff();
   string getName();
  };

 exception RangeError {
      int minValue;
      int maxValue;
  };

  interface SmartTv extends SmartDevice {
    bool changeChannel(int channelNr)
        throws RangeError;
    int getCurrentChannel();
  };

  interface Fridge extends SmartDevice {
    bool setTemperature(int temperature)
        throws RangeError;
    int getTemperature();
  };

  enum WeatherState { SUNNY, CLOUDY, WINDY };
  sequence<WeatherState> weatherStates;

  interface Thermometer  extends SmartDevice {
    int getTemperature();
    weatherStates getWeatherStates();
  };

};

#endif
