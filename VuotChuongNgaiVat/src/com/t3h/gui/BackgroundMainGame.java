package com.t3h.gui;

import com.t3h.chuyendulieu.ActionNewGameAndExit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Luan on 4/24/2016.
 */
public class BackgroundMainGame extends BaseContainer implements MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Image                backgroundFirst;
    private ImageIcon            icon;
    private ActionNewGameAndExit actionNewGameAndExit;

    public void setShowPlayGame(ActionNewGameAndExit actionNewGameAndExit) {
        this.actionNewGameAndExit = actionNewGameAndExit;
    }

    @Override
    public void initContainer() {
        icon = new ImageIcon(getClass()
                .getResource("/image/hinhnen2.png"));
        backgroundFirst = icon.getImage();
        addMouseListener(this);
    }

    @Override
    public void intiComps() {

    }

    @Override
    public void addComps() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundFirst, 0, 0, MyFrame.WIDTH, MyFrame.HEIGHT_FR,
                null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        actionNewGameAndExit.showPlayGame();
        PlayGame.GAME_START = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }}

