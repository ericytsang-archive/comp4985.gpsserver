package main;

import java.util.LinkedHashSet;
import java.util.Set;

public class GpsRecords
{
    private Set<GpsUpdateListener> registeredListeners;

    public GpsRecords()
    {
        registeredListeners = new LinkedHashSet<>();
    }

    public interface GpsUpdateListener
    {
        public void onGpsUpdate(long deviceId, double lat, double lng);
    }

    public void registerListener(GpsUpdateListener listener)
    {
        registeredListeners.add(listener);
    }

    public void unregisterListener(GpsUpdateListener listener)
    {
        registeredListeners.remove(listener);
    }
}
