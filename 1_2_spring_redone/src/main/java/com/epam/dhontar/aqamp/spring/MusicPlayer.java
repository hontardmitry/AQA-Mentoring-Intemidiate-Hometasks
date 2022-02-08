package com.epam.dhontar.aqamp.spring;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private String name;
    private int volume;

    public MusicPlayer() {}

    private List<Music> musicList = new ArrayList<>();
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public MusicPlayer(List<Music> musicList){
        this.musicList = musicList;
    }

    public void playMusicList(){
        musicList.forEach(music ->System.out.println("Playing " + music.getSong()));
    }

    public void playMusic(){
        System.out.println("Playing: " + music.getSong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
