
package sandboxclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import sandboxcontrol.Client;
import sandboxcontrol.Control;

public class testClient {
    public static void main(String[] args) throws IOException {
        
        Client client = new Client("localhost", 1429);
        Control control = new Control(client);
        Socket clientSocket = control.getClientSocket();
        control.messageSender(clientSocket);
        System.out.println(clientSocket);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String data = reader1.readLine();
    }
}
