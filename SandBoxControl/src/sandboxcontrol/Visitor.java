
package sandboxcontrol;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import javax.sound.sampled.AudioInputStream;


public class Visitor {
    private static int nbvisitor = 0;
    private int visitorId;
    private PrintStream out;
    private InputStream in;
    private String visitorName;
    private Socket client;
    
    
    public Visitor(Socket client, String visitorName) throws IOException{
        this.out = new PrintStream(client.getOutputStream());
        this.in = client.getInputStream();
        this.client = client;
        this.visitorName = visitorName;
        this.visitorId = nbvisitor;
        nbvisitor += 1;
    }

// getter
    public PrintStream getOut() {
        return out;
    }

 
    public InputStream getIn() {
        return in;
    }

    public String getVisitorName() {
        return visitorName;
    }

    /**
     * @return the client
     */
    public Socket getClient() {
        return client;
    }
}
