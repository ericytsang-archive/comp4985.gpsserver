package domain;

import java.net.InetAddress;
import java.sql.Time;

public class GpsRecord
{
    /**
     * ID of the device that sent the GPS update.
     */
    private final long deviceId;

    /**
     * IP address that was used to send the server the GPS update.
     */
    private final InetAddress deviceIp;

    /**
     * time that the latitude and longitude of the device was recorded.
     */
    private final Time samplingTime;

    /**
     * latitude of the device at samplingTime.
     */
    private final double lat;

    /**
     * longitude of the device at samplingTime.
     */
    private final double lng;

    /**
     * instantiates a new GPS record object.
     *
     * @param deviceId ID of the device that sent the GPS update.
     * @param deviceIp IP address that was used to send the server the GPS
     *   update.
     * @param samplingTime time that the latitude and longitude of the device
     *   was recorded.
     * @param lat latitude of the device at samplingTime.
     * @param lng longitude of the device at samplingTime.
     */
    public GpsRecord(long deviceId, InetAddress deviceIp, Time samplingTime,
            double lat, double lng)
    {
        this.deviceId = deviceId;
        this.deviceIp = deviceIp;
        this.samplingTime = samplingTime;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * returns the ID of the device that sent the GPS update.
     */
    public long getDeviceId()
    {
        return deviceId;
    }

    /**
     * returns the IP address that was used to send the server the GPS update.
     */
    public InetAddress getDeviceIp()
    {
        return deviceIp;
    }

    /**
     * returns the time that the latitude and longitude of the device was
     *   recorded.
     */
    public Time getSamplingTime()
    {
        return samplingTime;
    }

    /**
     * returns the latitude of the device at samplingTime.
     */
    public double getLat()
    {
        return lat;
    }

    /**
     * returns the longitude of the device at samplingTime.
     */
    public double getLng()
    {
        return lng;
    }
}
