/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fx30294
 */
public class PrintPersonThread extends Thread{
    private Person person;
    public PrintPersonThread(Person person){
        this.person = person;
    }
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
