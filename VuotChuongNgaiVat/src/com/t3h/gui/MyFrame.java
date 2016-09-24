package com.t3h.gui;

import com.t3h.chuyendulieu.GUIExit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Luan on 4/24/2016.
 */
public class MyFrame extends JFrame implements GUIExit {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int HEIGHT_FR = 600;
    public static final int WIDTH_FR = 800;

    private MyPanel myPanel;

    private WindowAdapter guiAdapter = new WindowAdapter() {

        @Override
        public void windowClosing(
                WindowEvent e) {
            int resuilt = JOptionPane
                    .showConfirmDialog(
                            null,
                            "Ban Co Muon Thoat Hay Khong",
                            "Thong Bao",
                            JOptionPane.YES_NO_OPTION);
            if (resuilt == JOptionPane.YES_OPTION) {
                dispose();
                PlayGame.IS_RUNNING = false;
            }
        }

    };

    public MyFrame() {
        initGUI();
        initComps();
        addComps();
    }

    private void initGUI() {
        this.setLayout(new CardLayout());
        this.setTitle("Khung Long");
        this.setSize(WIDTH_FR, HEIGHT_FR);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initComps() {
        myPanel = new MyPanel();
        myPanel.setExitGame(this);
    }

    private void addComps() {
        add(myPanel);
        addWindowListener(guiAdapter);
    }

    @Override
    public void exit() {
        dispose();

    }
}
