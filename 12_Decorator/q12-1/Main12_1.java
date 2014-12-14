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
public class Main12_1 {
    public static void main(String[] args){
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new UpDownBorder(b1, '-');
        Display b3 = new SideBorder(b2,'*');
        b1.show();
        b2.show();
        b3.show();
        
        Display b4 = new FullBorder(new UpDownBorder(new SideBorder(new UpDownBorder
        (new SideBorder(new StringDisplay("Hello"),'*'), '='
        ),'|'),'/'));
        System.out.println("\n ↓b4↓\n");
        b4.show();
    }
}
