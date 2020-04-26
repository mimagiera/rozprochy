# -*- coding: utf-8 -*-
#
# Copyright (c) ZeroC, Inc. All rights reserved.
#
#
# Ice version 3.7.3
#
# <auto-generated>
#
# Generated from file `smarthouse.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

from sys import version_info as _version_info_
import Ice, IcePy

# Start of module SmartHouseModule
_M_SmartHouseModule = Ice.openModule('SmartHouseModule')
__name__ = 'SmartHouseModule'

_M_SmartHouseModule._t_SmartDevice = IcePy.defineValue('::SmartHouseModule::SmartDevice', Ice.Value, -1, (), False, True, None, ())

if 'SmartDevicePrx' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.SmartDevicePrx = Ice.createTempClass()
    class SmartDevicePrx(Ice.ObjectPrx):

        def getStatus(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getStatus.invoke(self, ((), context))

        def getStatusAsync(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getStatus.invokeAsync(self, ((), context))

        def begin_getStatus(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getStatus.begin(self, ((), _response, _ex, _sent, context))

        def end_getStatus(self, _r):
            return _M_SmartHouseModule.SmartDevice._op_getStatus.end(self, _r)

        def turnOn(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOn.invoke(self, ((), context))

        def turnOnAsync(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOn.invokeAsync(self, ((), context))

        def begin_turnOn(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOn.begin(self, ((), _response, _ex, _sent, context))

        def end_turnOn(self, _r):
            return _M_SmartHouseModule.SmartDevice._op_turnOn.end(self, _r)

        def turnOff(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOff.invoke(self, ((), context))

        def turnOffAsync(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOff.invokeAsync(self, ((), context))

        def begin_turnOff(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartDevice._op_turnOff.begin(self, ((), _response, _ex, _sent, context))

        def end_turnOff(self, _r):
            return _M_SmartHouseModule.SmartDevice._op_turnOff.end(self, _r)

        def getName(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getName.invoke(self, ((), context))

        def getNameAsync(self, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getName.invokeAsync(self, ((), context))

        def begin_getName(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartDevice._op_getName.begin(self, ((), _response, _ex, _sent, context))

        def end_getName(self, _r):
            return _M_SmartHouseModule.SmartDevice._op_getName.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_SmartHouseModule.SmartDevicePrx.ice_checkedCast(proxy, '::SmartHouseModule::SmartDevice', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_SmartHouseModule.SmartDevicePrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::SmartDevice'
    _M_SmartHouseModule._t_SmartDevicePrx = IcePy.defineProxy('::SmartHouseModule::SmartDevice', SmartDevicePrx)

    _M_SmartHouseModule.SmartDevicePrx = SmartDevicePrx
    del SmartDevicePrx

    _M_SmartHouseModule.SmartDevice = Ice.createTempClass()
    class SmartDevice(Ice.Object):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::SmartHouseModule::SmartDevice')

        def ice_id(self, current=None):
            return '::SmartHouseModule::SmartDevice'

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::SmartDevice'

        def getStatus(self, current=None):
            raise NotImplementedError("servant method 'getStatus' not implemented")

        def turnOn(self, current=None):
            raise NotImplementedError("servant method 'turnOn' not implemented")

        def turnOff(self, current=None):
            raise NotImplementedError("servant method 'turnOff' not implemented")

        def getName(self, current=None):
            raise NotImplementedError("servant method 'getName' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_SmartHouseModule._t_SmartDeviceDisp)

        __repr__ = __str__

    _M_SmartHouseModule._t_SmartDeviceDisp = IcePy.defineClass('::SmartHouseModule::SmartDevice', SmartDevice, (), None, ())
    SmartDevice._ice_type = _M_SmartHouseModule._t_SmartDeviceDisp

    SmartDevice._op_getStatus = IcePy.Operation('getStatus', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())
    SmartDevice._op_turnOn = IcePy.Operation('turnOn', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())
    SmartDevice._op_turnOff = IcePy.Operation('turnOff', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_bool, False, 0), ())
    SmartDevice._op_getName = IcePy.Operation('getName', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_string, False, 0), ())

    _M_SmartHouseModule.SmartDevice = SmartDevice
    del SmartDevice

if 'RangeError' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.RangeError = Ice.createTempClass()
    class RangeError(Ice.UserException):
        def __init__(self, minValue=0, maxValue=0):
            self.minValue = minValue
            self.maxValue = maxValue

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_id = '::SmartHouseModule::RangeError'

    _M_SmartHouseModule._t_RangeError = IcePy.defineException('::SmartHouseModule::RangeError', RangeError, (), False, None, (
        ('minValue', (), IcePy._t_int, False, 0),
        ('maxValue', (), IcePy._t_int, False, 0)
    ))
    RangeError._ice_type = _M_SmartHouseModule._t_RangeError

    _M_SmartHouseModule.RangeError = RangeError
    del RangeError

_M_SmartHouseModule._t_SmartTv = IcePy.defineValue('::SmartHouseModule::SmartTv', Ice.Value, -1, (), False, True, None, ())

if 'SmartTvPrx' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.SmartTvPrx = Ice.createTempClass()
    class SmartTvPrx(_M_SmartHouseModule.SmartDevicePrx):

        def changeChannel(self, channelNr, context=None):
            return _M_SmartHouseModule.SmartTv._op_changeChannel.invoke(self, ((channelNr, ), context))

        def changeChannelAsync(self, channelNr, context=None):
            return _M_SmartHouseModule.SmartTv._op_changeChannel.invokeAsync(self, ((channelNr, ), context))

        def begin_changeChannel(self, channelNr, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartTv._op_changeChannel.begin(self, ((channelNr, ), _response, _ex, _sent, context))

        def end_changeChannel(self, _r):
            return _M_SmartHouseModule.SmartTv._op_changeChannel.end(self, _r)

        def getCurrentChannel(self, context=None):
            return _M_SmartHouseModule.SmartTv._op_getCurrentChannel.invoke(self, ((), context))

        def getCurrentChannelAsync(self, context=None):
            return _M_SmartHouseModule.SmartTv._op_getCurrentChannel.invokeAsync(self, ((), context))

        def begin_getCurrentChannel(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.SmartTv._op_getCurrentChannel.begin(self, ((), _response, _ex, _sent, context))

        def end_getCurrentChannel(self, _r):
            return _M_SmartHouseModule.SmartTv._op_getCurrentChannel.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_SmartHouseModule.SmartTvPrx.ice_checkedCast(proxy, '::SmartHouseModule::SmartTv', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_SmartHouseModule.SmartTvPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::SmartTv'
    _M_SmartHouseModule._t_SmartTvPrx = IcePy.defineProxy('::SmartHouseModule::SmartTv', SmartTvPrx)

    _M_SmartHouseModule.SmartTvPrx = SmartTvPrx
    del SmartTvPrx

    _M_SmartHouseModule.SmartTv = Ice.createTempClass()
    class SmartTv(_M_SmartHouseModule.SmartDevice):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::SmartHouseModule::SmartDevice', '::SmartHouseModule::SmartTv')

        def ice_id(self, current=None):
            return '::SmartHouseModule::SmartTv'

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::SmartTv'

        def changeChannel(self, channelNr, current=None):
            raise NotImplementedError("servant method 'changeChannel' not implemented")

        def getCurrentChannel(self, current=None):
            raise NotImplementedError("servant method 'getCurrentChannel' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_SmartHouseModule._t_SmartTvDisp)

        __repr__ = __str__

    _M_SmartHouseModule._t_SmartTvDisp = IcePy.defineClass('::SmartHouseModule::SmartTv', SmartTv, (), None, (_M_SmartHouseModule._t_SmartDeviceDisp,))
    SmartTv._ice_type = _M_SmartHouseModule._t_SmartTvDisp

    SmartTv._op_changeChannel = IcePy.Operation('changeChannel', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (((), IcePy._t_int, False, 0),), (), ((), IcePy._t_bool, False, 0), (_M_SmartHouseModule._t_RangeError,))
    SmartTv._op_getCurrentChannel = IcePy.Operation('getCurrentChannel', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_int, False, 0), ())

    _M_SmartHouseModule.SmartTv = SmartTv
    del SmartTv

_M_SmartHouseModule._t_Fridge = IcePy.defineValue('::SmartHouseModule::Fridge', Ice.Value, -1, (), False, True, None, ())

if 'FridgePrx' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.FridgePrx = Ice.createTempClass()
    class FridgePrx(_M_SmartHouseModule.SmartDevicePrx):

        def setTemperature(self, temperature, context=None):
            return _M_SmartHouseModule.Fridge._op_setTemperature.invoke(self, ((temperature, ), context))

        def setTemperatureAsync(self, temperature, context=None):
            return _M_SmartHouseModule.Fridge._op_setTemperature.invokeAsync(self, ((temperature, ), context))

        def begin_setTemperature(self, temperature, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.Fridge._op_setTemperature.begin(self, ((temperature, ), _response, _ex, _sent, context))

        def end_setTemperature(self, _r):
            return _M_SmartHouseModule.Fridge._op_setTemperature.end(self, _r)

        def getTemperature(self, context=None):
            return _M_SmartHouseModule.Fridge._op_getTemperature.invoke(self, ((), context))

        def getTemperatureAsync(self, context=None):
            return _M_SmartHouseModule.Fridge._op_getTemperature.invokeAsync(self, ((), context))

        def begin_getTemperature(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.Fridge._op_getTemperature.begin(self, ((), _response, _ex, _sent, context))

        def end_getTemperature(self, _r):
            return _M_SmartHouseModule.Fridge._op_getTemperature.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_SmartHouseModule.FridgePrx.ice_checkedCast(proxy, '::SmartHouseModule::Fridge', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_SmartHouseModule.FridgePrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::Fridge'
    _M_SmartHouseModule._t_FridgePrx = IcePy.defineProxy('::SmartHouseModule::Fridge', FridgePrx)

    _M_SmartHouseModule.FridgePrx = FridgePrx
    del FridgePrx

    _M_SmartHouseModule.Fridge = Ice.createTempClass()
    class Fridge(_M_SmartHouseModule.SmartDevice):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::SmartHouseModule::Fridge', '::SmartHouseModule::SmartDevice')

        def ice_id(self, current=None):
            return '::SmartHouseModule::Fridge'

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::Fridge'

        def setTemperature(self, temperature, current=None):
            raise NotImplementedError("servant method 'setTemperature' not implemented")

        def getTemperature(self, current=None):
            raise NotImplementedError("servant method 'getTemperature' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_SmartHouseModule._t_FridgeDisp)

        __repr__ = __str__

    _M_SmartHouseModule._t_FridgeDisp = IcePy.defineClass('::SmartHouseModule::Fridge', Fridge, (), None, (_M_SmartHouseModule._t_SmartDeviceDisp,))
    Fridge._ice_type = _M_SmartHouseModule._t_FridgeDisp

    Fridge._op_setTemperature = IcePy.Operation('setTemperature', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (((), IcePy._t_int, False, 0),), (), ((), IcePy._t_bool, False, 0), (_M_SmartHouseModule._t_RangeError,))
    Fridge._op_getTemperature = IcePy.Operation('getTemperature', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_int, False, 0), ())

    _M_SmartHouseModule.Fridge = Fridge
    del Fridge

if 'WeatherState' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.WeatherState = Ice.createTempClass()
    class WeatherState(Ice.EnumBase):

        def __init__(self, _n, _v):
            Ice.EnumBase.__init__(self, _n, _v)

        def valueOf(self, _n):
            if _n in self._enumerators:
                return self._enumerators[_n]
            return None
        valueOf = classmethod(valueOf)

    WeatherState.SUNNY = WeatherState("SUNNY", 0)
    WeatherState.CLOUDY = WeatherState("CLOUDY", 1)
    WeatherState.WINDY = WeatherState("WINDY", 2)
    WeatherState._enumerators = { 0:WeatherState.SUNNY, 1:WeatherState.CLOUDY, 2:WeatherState.WINDY }

    _M_SmartHouseModule._t_WeatherState = IcePy.defineEnum('::SmartHouseModule::WeatherState', WeatherState, (), WeatherState._enumerators)

    _M_SmartHouseModule.WeatherState = WeatherState
    del WeatherState

if '_t_weatherStates' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule._t_weatherStates = IcePy.defineSequence('::SmartHouseModule::weatherStates', (), _M_SmartHouseModule._t_WeatherState)

_M_SmartHouseModule._t_Thermometer = IcePy.defineValue('::SmartHouseModule::Thermometer', Ice.Value, -1, (), False, True, None, ())

if 'ThermometerPrx' not in _M_SmartHouseModule.__dict__:
    _M_SmartHouseModule.ThermometerPrx = Ice.createTempClass()
    class ThermometerPrx(_M_SmartHouseModule.SmartDevicePrx):

        def getTemperature(self, context=None):
            return _M_SmartHouseModule.Thermometer._op_getTemperature.invoke(self, ((), context))

        def getTemperatureAsync(self, context=None):
            return _M_SmartHouseModule.Thermometer._op_getTemperature.invokeAsync(self, ((), context))

        def begin_getTemperature(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.Thermometer._op_getTemperature.begin(self, ((), _response, _ex, _sent, context))

        def end_getTemperature(self, _r):
            return _M_SmartHouseModule.Thermometer._op_getTemperature.end(self, _r)

        def getWeatherStates(self, context=None):
            return _M_SmartHouseModule.Thermometer._op_getWeatherStates.invoke(self, ((), context))

        def getWeatherStatesAsync(self, context=None):
            return _M_SmartHouseModule.Thermometer._op_getWeatherStates.invokeAsync(self, ((), context))

        def begin_getWeatherStates(self, _response=None, _ex=None, _sent=None, context=None):
            return _M_SmartHouseModule.Thermometer._op_getWeatherStates.begin(self, ((), _response, _ex, _sent, context))

        def end_getWeatherStates(self, _r):
            return _M_SmartHouseModule.Thermometer._op_getWeatherStates.end(self, _r)

        @staticmethod
        def checkedCast(proxy, facetOrContext=None, context=None):
            return _M_SmartHouseModule.ThermometerPrx.ice_checkedCast(proxy, '::SmartHouseModule::Thermometer', facetOrContext, context)

        @staticmethod
        def uncheckedCast(proxy, facet=None):
            return _M_SmartHouseModule.ThermometerPrx.ice_uncheckedCast(proxy, facet)

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::Thermometer'
    _M_SmartHouseModule._t_ThermometerPrx = IcePy.defineProxy('::SmartHouseModule::Thermometer', ThermometerPrx)

    _M_SmartHouseModule.ThermometerPrx = ThermometerPrx
    del ThermometerPrx

    _M_SmartHouseModule.Thermometer = Ice.createTempClass()
    class Thermometer(_M_SmartHouseModule.SmartDevice):

        def ice_ids(self, current=None):
            return ('::Ice::Object', '::SmartHouseModule::SmartDevice', '::SmartHouseModule::Thermometer')

        def ice_id(self, current=None):
            return '::SmartHouseModule::Thermometer'

        @staticmethod
        def ice_staticId():
            return '::SmartHouseModule::Thermometer'

        def getTemperature(self, current=None):
            raise NotImplementedError("servant method 'getTemperature' not implemented")

        def getWeatherStates(self, current=None):
            raise NotImplementedError("servant method 'getWeatherStates' not implemented")

        def __str__(self):
            return IcePy.stringify(self, _M_SmartHouseModule._t_ThermometerDisp)

        __repr__ = __str__

    _M_SmartHouseModule._t_ThermometerDisp = IcePy.defineClass('::SmartHouseModule::Thermometer', Thermometer, (), None, (_M_SmartHouseModule._t_SmartDeviceDisp,))
    Thermometer._ice_type = _M_SmartHouseModule._t_ThermometerDisp

    Thermometer._op_getTemperature = IcePy.Operation('getTemperature', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), IcePy._t_int, False, 0), ())
    Thermometer._op_getWeatherStates = IcePy.Operation('getWeatherStates', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, None, (), (), (), ((), _M_SmartHouseModule._t_weatherStates, False, 0), ())

    _M_SmartHouseModule.Thermometer = Thermometer
    del Thermometer

# End of module SmartHouseModule
