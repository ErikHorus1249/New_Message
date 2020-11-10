
import java.net.NetworkInterface;
import java.util.Enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erik
 */
public class NIC {
    public static void main(String[] args) throws Exception{
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        
        while(nifs!=null){
            System.out.println(nifs);
        }
    }
}
