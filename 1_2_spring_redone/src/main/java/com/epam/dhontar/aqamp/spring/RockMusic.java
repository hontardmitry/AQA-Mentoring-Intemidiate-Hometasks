package com.epam.dhontar.aqamp.spring;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }

    //    private RockMusic(){}
    //    public  static RockMusic getRockMusic(){
    //        return new RockMusic();
    //    }
}
