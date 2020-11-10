/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandboxcontrol;

// bat nhung tin nhan duoc gui toi

import java.io.InputStream;
import java.util.Scanner;

public class ReceivedHandler implements Runnable{
    
    private InputStream in;
    
    public  ReceivedHandler(InputStream in){
        this.in = in;
    } 
    @Override
    public void run() {
        //bat tin nhan tu server va hien thi
        Scanner sc = new Scanner(in);
        String buff = "";
        while(sc.hasNext()){
            buff = sc.nextLine();
            System.out.println(buff);
            
        }
    }
    
}
