/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample;

/**
 *
 * @author Shohei
 */
public class Main12_2 {
    public static void main(String[] args){
    MultiStringDisplay md = new MultiStringDisplay();
    md.add("Good morning.");
    md.add("Hello.");
    md.add("Good night, see you tomorrow.");
    md.show();
    
    Display d1 = new SideBorder(md, '#');
    d1.show();
    
    Display d2 = new FullBorder(md);
    d2.show();
    }
}
