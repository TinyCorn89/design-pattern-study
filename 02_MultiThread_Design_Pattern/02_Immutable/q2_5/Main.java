/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2_5;

/**
 *
 * @author fx30294
 */
public class Main {
    public static void main(String[ ] args){
        Point p1 = new Point(0, 0);
        Point p2 = new Point (100, 0);
        Line line = new Line(p1, p2);
        //LineA2_4 line = new LineA2_4(p1, p2);
        
        System.out.println("line = " + line);
        
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;
        /*
        int p1x = line.getStartX();
        p1x = 150;
        */
        
        System.out.println("line = " + line);
        
    }
}
