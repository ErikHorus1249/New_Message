
package sandboxcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextPane;

public class Control {
    private Socket socket;
    private JTextPane MessageConsole;
    private PrintStream out;
    private BufferedReader reader;
    private Server server;
    private Client client;
    
    public Control(Socket socket, JTextPane MessageConole, PrintStream out,
            BufferedReader reader, Server server, Client client){
        this.socket = socket;
        this.MessageConsole = MessageConole;
        this.out = out;
        this.reader = reader;
        this.server = server;
        this.client = client;

    }
    
    public Control(Server server){
        
        this.server = server;
        this.out = out;
        this.reader = reader;
    }
    
    public Control(Client client){
        
        this.client = client;
        
    }
    
    // khoi tao server socket
    
    public ServerSocket getServerSocket() throws IOException{
        ServerSocket server1 = new ServerSocket(this.server.getPort());
        System.out.println("Server listenning . . .");
        return server1;
    }
    // khoi tao ClientSocket
    public Socket getClientSocket() throws IOException{
        Socket clientSocket = new Socket(this.client.getHost(), this.client.getPort());
        System.out.println("Connected client");
        return clientSocket;  
    } 
   
    public void messageReciever(){
        
    }
    
    public void messageSender(Socket socket) throws IOException{
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ten : \n");
        String vName = sc.nextLine();
        
        out.println(vName);// gui di ten cua visitor
        // thuc hien gui tin nhan khi co noi dung moi nhap vao
        System.out.println("Message : \n");
        while(sc.hasNextLine()){
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String data = reader1.readLine();
            if(data != null) System.out.println("Tu Server : "+data);
            messageRecieverHandle(socket);
            out.println(sc.nextLine());
        }
//        while(true){
//            BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String data = reader1.readLine();
//            if(data != null) System.out.println(data);     
//        }
        
//        sc.close();
//        out.close();
    }
    
    public void messageRecieverHandle(Socket socket) throws IOException{ // client
        InputStream in = socket.getInputStream();
        new Thread(new ReceivedHandler(in)).start();
    }
    
    public void addNewUser(Socket socket, Server server) throws IOException{// server
        Scanner sc = new Scanner(socket.getInputStream());
        String vName = sc.nextLine();
        vName = vadidate(vName); // chuan hoa ten chat
        
        Visitor newVisitor = new Visitor(socket, vName);
        
        server.add(newVisitor);
        
        new Thread( new VisitorHandler(server, newVisitor));
        
        sc.close();
    }
    
    // xoa user ra khoi list
    public void removeUser(Server server, Visitor visitor){
        server.removeVisitor(visitor);
    }
    
    public String vadidate(String inputString){ // Server
        inputString = inputString.replace(",", ""); // bo dau phay khi nhap ten tu phia client;
        inputString = inputString.replace(" ", "_"); // chuan hoa ten dau vao
        return inputString;
    }
    
//    public static void main(String[] args) {
//        
//    }
    
}


 