
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erik
 */
public class MultiCastClient {
    public static void main(String[] args) throws Exception{
        MulticastSocket client = new MulticastSocket(1107);
        client.joinGroup(InetAddress.getByName("224.2.2.3"));
        
        while(true){
//            Byte buf = new Byte(1024);
        }
    }
}
