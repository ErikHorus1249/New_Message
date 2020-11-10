package sandboxcontrol;

import java.util.ArrayList;
import java.util.List;

public class Server {
    
    private int port;
    private List<Visitor> visitorList; // danh sach cac visitor tham gia chat
    
    public Server() {
    }

    ;
    
    public Server(int port) {
        this.port = port;
        this.visitorList = new ArrayList<Visitor>();
    }
    
    public void add(Visitor v) {
        this.visitorList.add(v);
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    
    public void showVisitorList() {
        for (Visitor v : visitorList) {
            System.out.println(v.getVisitorName() + "\n");
        }
    }
    
    public void removeVisitor(Visitor v) {
        this.visitorList.remove(v);
    }
    
    public  List<Visitor> getVisitorList(){
        return this.visitorList;
    }
    
    // gui list nhung nguoi trong ket noi cho nhau
    public void sendListVisitor(){
        for(Visitor clientSocket : this.getVisitorList()){
            clientSocket.getOut().println(this.getVisitorList());
        }
        System.out.println("Gui thanh cong");
    }
}
