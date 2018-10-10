package tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class SocketServer {
    int portNumber = 9090;
    ServerSocket serverSocket = null;
    
    public void runServer(){
        try{
           serverSocket = new ServerSocket(portNumber);
        }catch(IOException e){           
            System.out.println(e.getMessage());
        }
        while(true){
            try{
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection Accepted for " + clientSocket.getInetAddress());
                TcpRunnable m = new TcpRunnable(clientSocket);
                new Thread(m).start();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
}
