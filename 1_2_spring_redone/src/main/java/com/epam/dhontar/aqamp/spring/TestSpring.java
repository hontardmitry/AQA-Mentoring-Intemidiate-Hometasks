package com.epam.dhontar.aqamp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );
        Music rockMusic = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playMusicList();


//        System.out.println(rockMusic.getSong());
//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean areTheSameObj = firstMusicPlayer == secondMusicPlayer;
//        System.out.println(areTheSameObj);
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(10);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());
//        firstMusicPlayer.playMusicList();
//        System.out.println(firstMusicPlayer.getName());
//        System.out.println(firstMusicPlayer.getVolume());
        context.close();
    }

}
