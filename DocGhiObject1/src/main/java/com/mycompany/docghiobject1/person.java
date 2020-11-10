/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.docghiobject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author erik
 */
public class person implements Serializable{
    
    private String name;
    private int Id;
    private static final long seriablVersionUID = 1L;
    
    public person(){};
    public person(String name, int Id){
        this.name = name;
        this.Id = Id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        person p = new person("tuan anh", 1);

        File f = new File("file.txt");
    
        if(!f.exists()){
            f.createNewFile();
        }
        
        FileOutputStream fos = new FileOutputStream(f);
    
        ObjectOutputStream os = new ObjectOutputStream(fos);
        
        os.writeObject(p);
        
        os.close();
        fos.close();
        
        FileInputStream fis = new FileInputStream(f);
        
        ObjectInputStream oi = new ObjectInputStream(fis);
        
        person p1 =  (person)oi.readObject();
        
        System.out.println(p1.getName() + "\n");
        System.out.println(p1.getId() + "\n");
        
    }
    
}
