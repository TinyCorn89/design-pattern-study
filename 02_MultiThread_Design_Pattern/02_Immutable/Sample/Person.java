/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fx30294
 */
public final class Person {
    private final String name;
    private final String address;
    public Person (String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    @Override
    public String toString(){
        return "[ Person : name = " + name + ", address = " + address + " ] ";
    }
}
