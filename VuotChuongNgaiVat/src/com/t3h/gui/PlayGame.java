package com.t3h.gui;

import com.t3h.chuyendulieu.ActionNewGameAndExit;
import com.t3h.chuyendulieu.ActionShowScore;
import com.t3h.manager.GameManager;
import com.t3h.manager.ManagerSounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.BitSet;


/**
 * Created by Luan on 4/25/2016.
 */
public class PlayGame extends BaseContainer implements ActionShowScore,Runnable,KeyListener {
    public static boolean IS_RUNNING;
    public static boolean IS_ZUMP;
    public static boolean  GAME_START;
    private static final long    serialVersionUID = 1L;
    public int time = 0;
    private int                  readScore        = 0;
    private String               readName;
    int score;
    private BitSet bitSet = new BitSet(256);

    private  ActionNewGameAndExit actionNewGameAndExit;

    private GameManager              gameManager;
    private ManagerSounds          managerSounds;
    private JLabel               lbScore, lbGetScore, lbHiSroce,
            lbGetHightScore;
    public static final Font     font             = new Font("Luan",
            Font.BOLD, 20);
    private String               path             = "score.txt";



    public PlayGame(){

        initGame();

        gameManager = new GameManager();
        managerSounds = new ManagerSounds();

        setFocusable(true);
        addKeyListener(this);
    }
    public void setActionNewGame(ActionNewGameAndExit actionNewGameAndExit) {
        this.actionNewGameAndExit = actionNewGameAndExit;
    }
    @Override
    public void initContainer() {
        FontMetrics fontMetrics = getFontMetrics(font);

        String titleDiem = "Score:";
        lbScore = new JLabel(titleDiem);
        int lbScoreW = fontMetrics.stringWidth(titleDiem);
        int lbScoreH = fontMetrics.getHeight();
        lbScore.setBounds(10, 5, lbScoreW, lbScoreH);
        lbScore.setFont(font);
        lbScore.setForeground(Color.YELLOW);

        lbGetScore = new JLabel("0");
        lbGetScore.setBounds(lbScore.getLocation().x + lbScore.getWidth() + 10,
                6, 100, lbScoreH);
        lbGetScore.setFont(font);
        lbGetScore.setForeground(Color.RED);

        String hightScore = "Hight Score:";
        lbHiSroce = new JLabel(hightScore);
        int hightScoreW = fontMetrics.stringWidth(hightScore);
        int hightScoreH = fontMetrics.getHeight();
        lbHiSroce.setBounds(10, lbScore.getHeight() + 10, hightScoreW,
                hightScoreH);
        lbHiSroce.setFont(font);
        lbHiSroce.setForeground(Color.PINK);

        lbGetHightScore = new JLabel();
        lbGetHightScore.setBounds(
                lbHiSroce.getLocation().x + lbHiSroce.getWidth() + 10, 35, 100,
                lbScoreH);
        lbGetHightScore.setFont(font);
        lbGetHightScore.setForeground(Color.RED);
    }

    @Override
    public void intiComps() {

    }

    @Override
    public void addComps() {
            add(lbScore);
            add(lbGetScore);
            add(lbHiSroce);
            add(lbGetHightScore);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        gameManager.drawObject(g2d);
    }

    public void initGame() {
        IS_RUNNING = true;
        GAME_START = true;
        IS_ZUMP = true;
        gameManager = new GameManager();
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        while (IS_RUNNING) {
            readHightScore(path);
            score = readScore;
            lbGetHightScore.setText(readScore+"");

            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (IS_ZUMP == true) {
            if (bitSet.get(KeyEvent.VK_SPACE) ) {
                    gameManager.dinosaurFly();
                    managerSounds.getFly().play();
                }
            }
            if (GAME_START) {
                gameManager.moveItem(time);
                gameManager.dinosaurFalling();
                gameManager.moveBackground(time);
                gameManager.moveGround(time);
                gameManager.moveZombie(time);
                gameManager.eatItem();
                lbGetScore.setText("" + gameManager.getDiem());

                if (gameManager.checkZump() == true){
                    IS_ZUMP = true;
                }
                else if (gameManager.checkZump() == false){
                    IS_ZUMP = false;
                }

                if (gameManager.testCollistion() == true) {
                    IS_RUNNING = false;
                    managerSounds.getGameOver().play();
                    if (gameManager.getDiem() > score) {
                        String name = JOptionPane.showInputDialog(
                                PlayGame.this, "Lưu Thông Tin",
                                "Save", 2);
                        if (name != null) {
                            writeHightScore(path, name,
                                    gameManager.getDiem());
                        }
                      }

                        int resuilt = JOptionPane.showConfirmDialog(
                                null, "Ban co muon choi tiep khong",
                                "Thong bao!",
                                JOptionPane.YES_NO_OPTION);
                        bitSet.clear();
                        if (resuilt == JOptionPane.YES_OPTION) {
                            gameManager = new GameManager();
                            IS_RUNNING = true;
                        } else if (resuilt == JOptionPane.NO_OPTION) {
                            IS_RUNNING = false;
                            actionNewGameAndExit.showMenuGame();
                        }

                    }

                if (gameManager.eatItem() ==  true){
                    managerSounds.getEatItem().play();
                }
                }
            time++;
            repaint();
            }
                IS_RUNNING = false;
        }

    public void diemCao() {
        readHightScore(path);
        String name = readName;
        int socre = readScore;
        JOptionPane.showMessageDialog(this, "Name:" + name + "\n"
                + " Hight Score:" + socre);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        bitSet.set(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        bitSet.clear(e.getKeyCode());

    }
    public void writeHightScore(String path,String name, int score) {
        File file = new File(path);
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // mo file de ghi
        try {
            FileOutputStream output = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    output));
            String sco = name + "_" + score;
            bw.write(sco);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHightScore(String path) {

        String[] hightScore;
        File file = new File(path);
        if (file.exists()) {
            FileReader read;
            try {
                read = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = bufferedReader.readLine();
                while (line != null) {
                    hightScore = line.split("_");
                    String readName = hightScore[0];
                    readScore = Integer.parseInt(hightScore[1]);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showScore() {
        diemCao();
    }
}



