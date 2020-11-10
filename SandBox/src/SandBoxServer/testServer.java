
package SandBoxServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import sandboxcontrol.Control;
import sandboxcontrol.Server;
import sandboxcontrol.Visitor;

public class testServer {
    
    public static void main(String[] args) throws IOException {
        
        Server ser = new Server(1429);
        Control control = new Control(ser);
        ServerSocket serverSoc = control.getServerSocket();
//        Thread t = new Thread();
        while(true){
            Socket client =  serverSoc.accept();
            System.out.println("Connected !");
            control.addNewUser(client, ser);
//            
            for (Visitor v : ser.getVisitorList()) {
                System.out.println(v.getVisitorName());
            }
            
            
//            System.out.println(ser.getVisitorList());
//            ser.showVisitorList();
//            control.sendListVisitor(ser);

            
        }
    }
    
}
