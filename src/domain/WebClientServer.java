package domain;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 * this server is used to serve web clients.
 *
 * users using web browsers to connect to the Apache web server to get a map
 *   that has markers that display where people currently are will also connect
 *   to this web server using a web socket. this server will send GPS updates to
 *   all connected clients whenever a GPS update is received.
 *
 * @author Eric Tsang
 *
 */
public class WebClientServer extends WebSocketServer implements GpsRecordManager.GpsUpdateListener
{
    //////////////////////
    // public interface //
    //////////////////////

    public WebClientServer(int port, GpsRecordManager gpsRecords) throws UnknownHostException
    {
        super(new InetSocketAddress(port));
        gpsRecords.registerListener(this);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote)
    {
    }

    @Override
    public void onError(WebSocket conn, Exception e)
    {
    }

    @Override
    public void onMessage(WebSocket conn, String msg)
    {
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake)
    {
    }

    @Override
    public void onGpsUpdate(GpsRecord gpsRecord)
    {
    }
}
