/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterProblem2;
import java.io.*;
import java.util.*;

/**
 *
 * @author Shohei
 */
public class FileProperties extends Properties implements FileIO{
    
    public void readFormFile(String filename) throws  IOException{
        load(new FileInputStream(filename));        
    }
    
    public void writeToFile(String filename) throws IOException{
        store(new FileOutputStream(filename), "writen by FileProperties");        
    }
    
    public void setValue(String key, String value){
        setProperty(key, value);
    }
    
    public String getValue(String key){
        return getProperty(key,"");
    }
    
}
