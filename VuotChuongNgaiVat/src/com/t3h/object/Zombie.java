package com.t3h.object;

import com.t3h.gui.MyFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Luan on 4/24/2016.
 */
public class Zombie {


    protected int             x;
    protected int             y;

    public static final int ZOMBIE1      = 1;
    public static final int ZOMBIE2      = 2;
    public static final int ZOMBIE3     = 3;
    public static final int ZOMBIE4      = 4;
    public static final int ZOMBIE5      = 5;

    protected int             size;

    protected int           choose;

    public static final int SPEED_MOVE = 3;

    public int getX() {
        return x;
    }
    private Image[]         imgZombie  = new Image[] {
            new ImageIcon(getClass().getResource("/image/vatcan6.png"))
                    .getImage(),
            new ImageIcon(getClass().getResource("/image/vatcan2.png"))
                    .getImage(),
            new ImageIcon(getClass().getResource("/image/vatcan3.png"))
                    .getImage(),
            new ImageIcon(getClass().getResource("/image/vatcan4.png"))
                    .getImage(),
            new ImageIcon(getClass().getResource("/image/vatcan5.png"))
            .getImage()       };

    public Zombie(int x, int y, int size, int choose) {
        super();
        this.x = x;
        this.y = y;
        this.size = size;
        this.choose = choose;
    }

    public void moveZombie(int time) {
        if (time % SPEED_MOVE != 0) {
            return;
        }
        x -= 5;
    }

    public void drawZombie(Graphics2D g2d) {
        switch (choose) {
            case ZOMBIE1:
                g2d.drawImage(imgZombie[ZOMBIE1], x, y, size, size, null);
                break;
            case ZOMBIE2:
                g2d.drawImage(imgZombie[ZOMBIE2], x, y, size, size, null);
                break;
            case ZOMBIE3:
                g2d.drawImage(imgZombie[ZOMBIE3], x, y, size, size, null);
                break;
            case ZOMBIE4:
                g2d.drawImage(imgZombie[ZOMBIE4], x, y, size, size, null);
                break;
            case ZOMBIE5:
                g2d.drawImage(imgZombie[ZOMBIE5], x, y, size, size, null);
                break;
            default:
                break;
        }
    }

    public Rectangle getRectZombie() {
        Rectangle rectVatPham = new Rectangle(x, y, size, size);
        return rectVatPham;
    }
}
