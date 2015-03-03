package main;

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
public class WebClientServer extends WebSocketServer
{
    //////////////////////
    // public interface //
    //////////////////////

    public WebClientServer(int port, GpsRecords gpsRecords) throws UnknownHostException
    {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onClose(WebSocket conn, int arg1, String reason, boolean code)
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
}
