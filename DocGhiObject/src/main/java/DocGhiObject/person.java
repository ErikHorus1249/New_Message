/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DocGhiObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author erik
 */
public class person {
    
    private String name;
    private int Id;
    
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
    
    public static void main(String[] args) throws Exception{
        person p = new person("tuan anh", 1);

        File f = new File("file.txt");
    
        if(!f.exists()){
            f.createNewFile();
        }
        
        FileOutputStream fos = new FileOutputStream(f);
    
        ObjectOutputStream os = new ObjectOutputStream(fos);
        
        os.writeObject(p);
        
        
    }
    
}
