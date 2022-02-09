package com.epam.dhontar.aqamp.spring;


public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public void doMyInit(){
        System.out.println("Initializing...");
    }

    public void doMyDestroy(){
        System.out.println("Destroying...");
    }

}
