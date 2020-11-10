
package sandboxcontrol;

import java.util.Scanner;


public class VisitorHandler implements Runnable{
    private Server server;
    private Visitor visitor;
    
    public VisitorHandler(Server server, Visitor visitor){
        this.server = server;
        this.visitor = visitor;
        this.server.sendListVisitor();
    }

    @Override
    public void run() {
        String mess;
        
        Scanner sc = new Scanner(this.visitor.getIn());
        
        System.out.println("thread dang chay");
    }
}
