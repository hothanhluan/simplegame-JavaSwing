package com.t3h.background;

import com.t3h.gui.MyFrame;

import java.awt.*;

/**
 * Created by Luan on 4/24/2016.
 */
public class Ground {
    private int   x;
    private int   y;
    private int   width;
    private int   height;
    private Image imageNen;
    private int   speed = 3;

    public Ground(int x, int y, int width, int height, Image imgageNen) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imageNen = imgageNen;
    }

    public void drawMatDat(Graphics2D g2d) {
        g2d.drawImage(imageNen, x, y, width, height, null);
    }
    //dat di chuyen
    public void moveMatDat(int time) {
        //neu la boi cua 3 thi
        if (time % speed != 0) {
            return;
        }
        x -= 5;
        if (x == -MyFrame.WIDTH_FR) {
            x = MyFrame.WIDTH_FR;
        }
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public Rectangle getRectMatDat() {
        Rectangle rect = new Rectangle(x, y, width,height);
        return rect;
    }
}
