package org.example;

public class Alien {

    private int age; //we can set it here but we want spring to inject its value
    private Computer comp;

    public Alien(){
        System.out.println("Alien created...");
    }
    public Alien(int age){
        this.age = age;
    }

    public Alien(int age,Computer comp) {
        this.age = age;
        this.comp = comp;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){ //getter and setter should be here for bean property to work
        this.age = age;
    }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void code(){
        System.out.println("Coding...");
        comp.compile();
    }
}
