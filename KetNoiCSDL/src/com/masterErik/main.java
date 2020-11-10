
package com.masterErik;


public class main {

    public static void main(String[] args) {
        
        thread1 p1 = new thread1();
//        Thread t = new Thread(p1);
        
        thread2 p2 = new thread2();
        Thread t = new Thread(p2);
        
        p1.start();
        
        t.start();
        
    }
    
}
