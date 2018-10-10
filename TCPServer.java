package tcp.server;

/**
 *
 * @author Admin
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello Server !!!");
        SocketServer s = new SocketServer();
        s.runServer();
    }
    
}
