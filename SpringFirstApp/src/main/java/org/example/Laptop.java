package org.example;

public class Laptop implements Computer {

    @Override
    public void compile(){
        System.out.println("Compiling using Laptop...");
    }

}
