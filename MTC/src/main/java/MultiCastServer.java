
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erik
 */
public class MultiCastServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket server = new DatagramSocket();
//        BufferedReader in = null; 
        boolean moreQuotes = true;
        int i = 0;
        while(true){
//            byte[] buf = ("a mess " + i++).getBytes();
              InetAddress group = InetAddress.getByName("224.2.2.3");
              for(i = 0 ; i < 1000; i++){
                  String dString = i + "--" +  InetAddress.getLocalHost();
                  byte[] buf = dString.getBytes();
                  DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 1107);
                  server.send(packet);
                  Thread.sleep(1000);
              }
        }
    }
}
