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
public abstract class Border extends Display{
    protected Display display;
    protected Border(Display display){
        this.display = display;
    }
}
