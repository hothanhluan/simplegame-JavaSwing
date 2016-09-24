package com.t3h.object;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Luan on 4/24/2016.
 */
public class Item {
    public int getX() {
        return x;
    }

    private int             x;
    private int             y;

    public static final int ITEM0      = 0;

    private int       size;

    public static final int SPEED_MOVE = 3;

    private Image    imageItem  =
            new ImageIcon(getClass().getResource("/image/star.png")).getImage();


    public Item(int x, int y, int size) {
        super();
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void moveItem(int time) {
        if (time % SPEED_MOVE != 0) {
            return;
        }
        x -= 5;
    }

    public void drawItems(Graphics2D g2d) {
                g2d.drawImage(imageItem, x, y, size, size, null);
        }


    public Rectangle getRectItems() {
        Rectangle rectVatPham = new Rectangle(x, y, size, size);
        return rectVatPham;
    }

}
