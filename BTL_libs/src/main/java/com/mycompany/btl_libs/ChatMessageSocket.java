/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.btl_libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author erik
 */
public class ChatMessageSocket {
    private Socket socket;
    private JTextPane txpMessageBoard;
    private  PrintStream out;
    private BufferedReader reader;

    public ChatMessageSocket(Socket socket, JTextPane txpMessageBoard) throws IOException{
        this.socket = socket;
        this.txpMessageBoard = txpMessageBoard;
        
        out = new PrintStream(socket.getOutputStream());
        
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        receive();
       
    }
    
    private void receive(){
        Thread th =  new Thread(){
            public void run(){
                while(true){
                    try{
                        String  line = reader.readLine();
                        if(line != null){
                            txpMessageBoard.setText(txpMessageBoard.getText() +  "\n\n" + line);
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
        };
        th.start();
    }
    
    
    public void send(String msg){
        String current = txpMessageBoard.getText();
        txpMessageBoard.setText(current + "\n\nsent: " + msg);
        out.println(msg);
        out.flush();
    }
    
    public void close(){
        try {
            out.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
        }
    }        
}
