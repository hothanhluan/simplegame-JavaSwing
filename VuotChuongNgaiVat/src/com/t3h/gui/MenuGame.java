package com.t3h.gui;



import com.t3h.chuyendulieu.ActionNewGameAndExit;
import com.t3h.chuyendulieu.ActionShowScore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGame extends BaseContainer implements ActionListener {

    /**
     * 
     */
    private static final long    serialVersionUID = 1L;
    private ImageIcon            iconBackGround;
    private Image                backgroundMenuGame;
    private JButton              btNewGame, btHightSocre, btInstruction, btExit;

    private ActionNewGameAndExit actionNewGameAndExit;

    private ActionShowScore showScore;

    public void setActionShowScore(ActionShowScore actionShowScore) {
        this.showScore = actionShowScore;
    }

    public void setActionNewGameAndExit(
            ActionNewGameAndExit actionNewGameAndExit) {
        this.actionNewGameAndExit = actionNewGameAndExit;
    }

    @Override
    public void initContainer() {
        iconBackGround = new ImageIcon(getClass().getResource(
                "/image/hinhnen2.png"));
        backgroundMenuGame = iconBackGround.getImage();
        this.setLayout(null);

    }

    @Override
    public void intiComps() {
        // khoi tao button New Game
        ImageIcon imgNewGame, imgHightScore, imgInstruction, imgExit;

        imgNewGame = new ImageIcon(getClass()
                .getResource("/image/playgame.png"));
        btNewGame = new JButton();
        btNewGame.setIcon(imgNewGame);
        btNewGame.setBounds(MyFrame.WIDTH_FR / 2 - 80,
                MyFrame.HEIGHT_FR / 2 - 100, imgNewGame.getIconWidth(),
                imgNewGame.getIconHeight());
        btNewGame.setContentAreaFilled(false);
        btNewGame.setBorderPainted(false);

        // khoi tao button Hight Score
        imgHightScore = new ImageIcon(getClass().getResource(
                "/image/hightscore.png"));
        btHightSocre = new JButton();
        btHightSocre.setIcon(imgHightScore);
        btHightSocre.setBounds(MyFrame.WIDTH_FR / 2 - 80,
                btNewGame.getLocation().y + btNewGame.getHeight() + 15,
                imgHightScore.getIconWidth(), imgHightScore.getIconHeight());
        btHightSocre.setContentAreaFilled(false);
        btHightSocre.setBorderPainted(false);

        // khoi tao button Instruction
        imgInstruction = new ImageIcon(getClass().getResource(
                "/image/huongdan.png"));
        btInstruction = new JButton();
        btInstruction.setIcon(imgInstruction);
        btInstruction.setBounds(MyFrame.WIDTH_FR / 2 - 80,
                btHightSocre.getLocation().y + btHightSocre.getHeight() + 15,
                imgInstruction.getIconWidth(), imgInstruction.getIconHeight());
        btInstruction.setContentAreaFilled(false);
        btInstruction.setBorderPainted(false);


        // khoi tao button Exit
        imgExit = new ImageIcon(getClass().getResource("/image/exitgame.png"));
        btExit = new JButton();
        btExit.setIcon(imgExit);
        btExit.setBounds(MyFrame.WIDTH_FR / 2 - 80, btInstruction.getLocation().y
                + btInstruction.getHeight() + 15, imgExit.getIconWidth(),
                imgExit.getIconHeight());
        btExit.setContentAreaFilled(false);
        btExit.setBorderPainted(false);

        btNewGame.addActionListener(this);
        btHightSocre.addActionListener(this);
        btInstruction.addActionListener(this);
        btExit.addActionListener(this);
    }

    @Override
    public void addComps() {
        this.add(btNewGame);
        this.add(btHightSocre);
        this.add(btInstruction);
        this.add(btExit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundMenuGame, 0, 0, MyFrame.WIDTH_FR,
                MyFrame.HEIGHT_FR, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btNewGame)) {
            actionNewGameAndExit.showPlayGame();

        } else if (e.getSource().equals(btHightSocre)) {
            showScore.showScore();
        } else if (e.getSource().equals(btInstruction)) {
            JOptionPane
                    .showMessageDialog(
                            this,
                            "<html>Luật chơi:Bạn bấm phím Space trên bàn phìm để di chuyển con khung long.<br/>Tránh các con quái và ăn các vật phẩm .</html>");
        }
         else if (e.getSource().equals(btExit)) {
            actionNewGameAndExit.exitGame();
        }

    }

}
