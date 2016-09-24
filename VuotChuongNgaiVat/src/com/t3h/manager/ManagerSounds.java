package com.t3h.manager;

import java.applet.Applet;
import java.applet.AudioClip;

public class ManagerSounds {
    private AudioClip fly, eatItem, gameOver, nhacnen;

    public ManagerSounds() {
        initSound();
    }

    private void initSound() {

        fly = Applet.newAudioClip(getClass().getResource("/sound/nhacnhay.wav"));

        eatItem = Applet.newAudioClip(getClass()
                .getResource("/sound/anvang.wav"));

        gameOver = Applet.newAudioClip(getClass().getResource("/sound/die.wav"));

        nhacnen = Applet.newAudioClip(getClass().getResource("/sound/enter_game.wav" ));
    }

    public AudioClip getFly() {
        return fly;
    }

    public AudioClip getEatItem() {
        return eatItem;
    }

    public AudioClip getGameOver() {
        return gameOver;
    }
    public AudioClip getNhacnen(){
        return nhacnen;
    }


    
    
}
