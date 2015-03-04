package domain;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.java_websocket.handshake.ClientHandshake;

public class TCPServer
{
    private final ServerSocket serverSock;
    private AcceptThread acceptThread;

    public TCPServer(int serverPort) throws IOException
    {
        serverSock = new ServerSocket(serverPort);
    }

    /**
     * starts the server, and makes it listening for connections on the passed
     *   port.
     */
    public void start()
    {
        if(acceptThread == null)
        {
            acceptThread = new AcceptThread(serverSock);
            acceptThread.start();
        }
    }

    public void stop()
    {
        if(acceptThread != null)
        {
            acceptThread.cancel();
            acceptThread = null;
        }
    }

    protected void onClose(Socket conn, int code, String reason, boolean remote)
    {

    }

    protected void onError(Socket conn, Exception e)
    {

    }

    protected void onMessage(Socket conn, String msg)
    {

    }

    protected void onOpen(Socket conn)
    {
    }

    /**
     * the AcceptThread is the thread that's used to accept incoming connection
     *   requests, and pass them off to connected threads.
     */
    private class AcceptThread extends Thread
    {
        private ServerSocket svrSock;

        public AcceptThread(ServerSocket svrSock)
        {
            this.svrSock = svrSock;
        }

        /**
         * the threaded method.
         *
         * continuously accepts connections, and invokes the onOpen callback
         *   whenever a new connection is established.
         */
        public void run()
        {
            while(true)
            {
                try
                {
                    Socket conn = svrSock.accept();
                    onOpen(conn);
                }
                catch (IOException e)
                {
                    // notify all threads waiting for this thread to terminate
                    notifyAll();
                    break;
                }
            }
        }

        /**
         * closes the socket, and doesn't return until the socket is closed.
         */
        public void cancel()
        {
            try
            {
                svrSock.close();
                AcceptThread.this.wait();
            }
            catch (IOException | InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
