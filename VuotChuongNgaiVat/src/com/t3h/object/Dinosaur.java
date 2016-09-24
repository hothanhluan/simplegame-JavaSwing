package com.t3h.object;

import com.t3h.gui.MyFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Luan on 4/24/2016.
 */
public class Dinosaur {
    public static final int DINASAUR = 0;
    public static final int GRAVITY = 5;
    public static final int TERMINAL_VELOCITY = 5;
    public static final int SPEED_DEFAULT = 2;

    public boolean isZump() {
        return isZump;
    }

    public void setZump(boolean zump) {
        isZump = zump;
    }

    private boolean isZump = false;
    private int x;
    public int y;
    private int size;
    private Image imageDinosaur;

    public Dinosaur(int x, int y, int size ) {
        this.x = x;
        this.y = y;
        this.size = size;
        imageDinosaur = new ImageIcon(getClass().getResource("/image/nhanvat.gif")).getImage();
    }

    public void drawDinosaur(Graphics2D g2d) {
            g2d.drawImage(imageDinosaur, x, y, size, size, null);
    }

    public void falling() {
        if (y > MyFrame.HEIGHT_FR-135){
            return;
        }
            y += 3;
    }

    public void fly() {
            y -= 250;
    }

    public Rectangle getRectDinosaur() {
        Rectangle rect = new Rectangle(x, y, size, size);
        return rect;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


