package com.epam.dhontar.aqamp.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        context.close();
    }

    interface Music{}
    class ClassicalMusic implements Music{}
    class RockMusic implements Music{}
    class MusicPlayer{
        private Music music;

        public MusicPlayer(Music music){
            this.music = music;
        }

        public void playMusic(){

        }
    }
}
