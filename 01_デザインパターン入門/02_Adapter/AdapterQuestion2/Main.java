/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterProblem2;

import java.io.IOException;

/**
 *
 * @author Shohei
 */

public class Main{
public static void main(String[] args) {
        // TODO code application logic here
        FileIO fileIO = new FileProperties();
        try{
            fileIO.readFormFile("file.txt"); 
            fileIO.setValue("year", "2004");
            fileIO.setValue("month", "4");
            fileIO.setValue("day", "21");
            fileIO.writeToFile("newfile.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}