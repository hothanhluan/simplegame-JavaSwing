package com.t3h.manager;

import com.t3h.background.BackGround;
import com.t3h.background.Ground;
import com.t3h.gui.MyFrame;
import com.t3h.gui.PlayGame;
import com.t3h.object.Item;
import com.t3h.object.Zombie;
import com.t3h.object.Dinosaur;
import com.t3h.object.Zombie;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Luan on 4/24/2016.
 */
public class GameManager {

    private ArrayList<BackGround> listBackGround;
    private ArrayList<Ground> listGround;
    private ArrayList<Zombie> listZombie;
    private ArrayList<Dinosaur> listDinosaur;
    private ArrayList<Item> listItem;

    private Zombie zombie;
    private Item item;
    private BackGround backGround;
    private Ground ground;
    private Dinosaur dinosaur;

    private int x, y;

    public int getY() {
        return y;
    }

    private int size = 50;

    private Image imageGamePanel;
    private Image imageGround;

    private Random rd = new Random();

    private int score;

    public int getDiem() {
        return score;
    }

    public GameManager() {
        listBackGround = new ArrayList<>();
        listGround = new ArrayList<>();
        listZombie = new ArrayList<>();
        listItem = new ArrayList<>();

        initImage();

        initBackGround();

        initGround();

        initZombie();

        initDinosaur();

        initItem();

        dinosaurFly();
    }


    private void initImage() {

        imageGamePanel = new ImageIcon(getClass().getResource(
                "/image/anhnen4.png")).getImage();

        imageGround = new ImageIcon(getClass()
                .getResource("/image/matdat.png")).getImage();


    }

    public void initDinosaur() {
        dinosaur = new Dinosaur(MyFrame.WIDTH_FR / 6, MyFrame.HEIGHT_FR - 135, size);
    }

    public void initItem() {
        int width = 150;
        for (int k = 0; k < 5; k++) {
            x = MyFrame.WIDTH_FR + width * k;
            y = MyFrame.HEIGHT_FR - 235;
            item = new Item(x, y, 30);
            listItem.add(item);
        }
    }

    private void initBackGround() {
        for (int i = 0; i < 3; i++) {
            y = 0;
            x = i * MyFrame.WIDTH_FR;
            backGround = new BackGround(x, y, MyFrame.WIDTH_FR,
                    MyFrame.HEIGHT_FR, imageGamePanel);
            listBackGround.add(backGround);

        }
    }

    private void initGround() {
        for (int j = 0; j < 3; j++) {
            y = MyFrame.HEIGHT_FR - 90;
            x = j * MyFrame.WIDTH_FR;
            ground = new Ground(x, y, MyFrame.WIDTH_FR, 100, imageGround);
            listGround.add(ground);
        }
    }

    public void initZombie() {
        int choose = rd.nextInt(4) + 1;
        int width = 150;
        for (int k = 0; k < 4; k++) {
            x = MyFrame.WIDTH_FR + (width + 150) * k;
            y = MyFrame.HEIGHT_FR - 135;
            zombie = new Zombie(x, y, size, choose);
            listZombie.add(zombie);
        }
    }

    public void drawObject(Graphics2D g2d) {

        // ve mat nen bau troi
        for (int i = 0; i < listBackGround.size(); i++) {
            listBackGround.get(i).drawBackground(g2d);

        }

        // ve mat dat
        for (int i = 0; i < listGround.size(); i++) {
            listGround.get(i).drawMatDat(g2d);
        }
        // ve cay xuong rong
        for (int i = 0; i < listGround.size(); i++) {
            listZombie.get(i).drawZombie(g2d);
        }

        //ve vat pham
        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).drawItems(g2d);
        }
        // ve nhan vat
        dinosaur.drawDinosaur(g2d);
    }

    //di chuyen item
    public void moveItem(int time) {
        for (int i = 0; i < listItem.size(); i++) {
            listItem.get(i).moveItem(time);
            if (listItem.get(i).getX() == -70) {
                listItem.remove(i);
            }
            if (listItem.size() == 4) {
                initItem();
            }
        }
    }

    //di chuyen hinh nen
    public void moveBackground(int time) {
        for (int i = 0; i < listBackGround.size(); i++) {
            listBackGround.get(i).moveBackground(time);
        }
    }

    // di chuyen dat
    public void moveGround(int time) {
        for (int i = 0; i < listGround.size(); i++) {
            listGround.get(i).moveMatDat(time);
        }
    }

    //di chuyen  quoai vat
    public void moveZombie(int time) {
        for (int i = 0; i < listZombie.size(); i++) {
            listZombie.get(i).moveZombie(time);
            if (listZombie.get(i).getX() == -70) {
                listZombie.remove(i);
            }
            if (listZombie.size() == 4) {
                initZombie();
            }
        }
    }

    //khung long nhay len vuot qua chuong ngai vat
    public void dinosaurFly() {
            dinosaur.fly();
    }


    public void dinosaurFalling() {
            dinosaur.falling();
    }

    public boolean testCollistion() {
        for (int i = 0; i < listZombie.size(); i++) {
            if (dinosaur.getRectDinosaur().intersects(listZombie.get(i).getRectZombie())) {
                return true;
            }
        }
        return false;
    }

    public boolean eatItem() {
        for (int i = 0; i < listItem.size(); i++) {
            if (dinosaur.getRectDinosaur().intersects(listItem.get(i).getRectItems())) {
                listItem.remove(i);
                score += 1;
                return true;
            }
        }
        return false;
    }
    public boolean checkZump(){
        for (int i = 0; i < listGround.size(); i++) {
            if (dinosaur.getRectDinosaur().intersects(listGround.get(i).getRectMatDat())) {
                return true;
            }
        }
        return false;
    }
}

