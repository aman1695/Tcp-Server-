package tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TcpRunnable implements Runnable{
    protected Socket clientSocket = null;
    public TcpRunnable(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    public void run(){
        
        try{
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String res = getCipheredData(line);
                out.println(String.format("%s -> %s", line, res));
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private String getCipheredData(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if(c >= 'a' && c <= 'z') {
                int val = c - 'a';
                val = (val + 13)%26;
                stringBuilder.append((char)(val + 'a'));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
        
    }
}
 
