package com.epam.dhontar.aqamp.spring;

import org.springframework.stereotype.Component;

@Component("musicBean")
public class RockMusic implements Music{
    public void doMyInit(){
        System.out.println("Initializing...");
    }

    public void doMyDestroy(){
        System.out.println("Destroying...");
    }
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }

    //    private RockMusic(){}
    //    public  static RockMusic getRockMusic(){
    //        return new RockMusic();
    //    }
}
