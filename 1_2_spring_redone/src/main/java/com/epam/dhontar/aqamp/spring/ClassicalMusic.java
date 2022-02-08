package com.epam.dhontar.aqamp.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music{
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
    @PostConstruct
    public void doMyInit(){
        System.out.println("Initializing...");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Destroying...");
    }

}
