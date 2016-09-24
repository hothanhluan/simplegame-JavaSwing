package com.t3h.background;

import com.t3h.gui.MyFrame;

import java.awt.*;

/**
 * Created by Luan on 4/24/2016.
 */
    public class BackGround {
        private int   x;
        private int   y;
        private int   width, height;
        private Image imgBackground;

        private float speed = 10;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Image getImgBackground() {
            return imgBackground;
        }

        public BackGround(int x, int y, int width, int height, Image imgBackground) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.imgBackground = imgBackground;
        }

        public void drawBackground(Graphics2D g) {
            g.drawImage(imgBackground, x, y, width, height, null);
        }

        public void moveBackground(int time) {
            if (time % speed != 0) {
                return;
            }
            x -= 5;
            if (x == -MyFrame.WIDTH_FR) {
                x = MyFrame.WIDTH_FR;
            }
        }

        public Rectangle getRectNen() {
            Rectangle rect = new Rectangle(x, y, width, height);
            return rect;
        }
}
