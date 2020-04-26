//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.3
//
// <auto-generated>
//
// Generated from file `smarthouse.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHouseModule;

public class RangeError extends com.zeroc.Ice.UserException
{
    public RangeError()
    {
    }

    public RangeError(Throwable cause)
    {
        super(cause);
    }

    public RangeError(int minValue, int maxValue)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public RangeError(int minValue, int maxValue, Throwable cause)
    {
        super(cause);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String ice_id()
    {
        return "::SmartHouseModule::RangeError";
    }

    public int minValue;

    public int maxValue;

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHouseModule::RangeError", -1, true);
        ostr_.writeInt(minValue);
        ostr_.writeInt(maxValue);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        minValue = istr_.readInt();
        maxValue = istr_.readInt();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = 907915765L;
}
