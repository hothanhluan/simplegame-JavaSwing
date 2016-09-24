package com.t3h.gui;

import com.t3h.chuyendulieu.ActionNewGameAndExit;
import com.t3h.chuyendulieu.GUIExit;

import java.awt.*;

/**
 * Created by Luan on 5/3/2016.
 */
public class MyPanel extends BaseContainer implements ActionNewGameAndExit {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CardLayout mCard;
    private MenuGame          menuGame;
    private PlayGame          playGame;
    private BackgroundMainGame backgroundMainGame;
    public static String      MENU_ID         = "0";
    public static String      BACKGROUND_GAME = "1";
    public static String      PLAYGAME_ID     = "2";

    private GUIExit           guiExit;

    @Override
    public void initContainer() {
        mCard = new CardLayout();
        this.setLayout(mCard);

    }

    @Override
    public void intiComps() {
        menuGame = new MenuGame();
        backgroundMainGame = new BackgroundMainGame();
        playGame = new PlayGame();
        menuGame.setActionNewGameAndExit(this);
        backgroundMainGame.setShowPlayGame(this);
        playGame.setActionNewGame(this);
        menuGame.setActionShowScore(playGame);

    }

    @Override
    public void addComps() {
        add(menuGame, MENU_ID);
        add(backgroundMainGame,BACKGROUND_GAME);
        add(playGame, PLAYGAME_ID);
    }

    @Override
    public void showPlayGame(){
        playGame.initGame();
        mCard.show(MyPanel.this,PLAYGAME_ID);

        playGame.setFocusable(true);
        playGame.requestFocus(true);
    }

    @Override
    public void exitGame() {
        guiExit.exit();
    }

    @Override
    public void showMenuGame() {
        mCard.show(MyPanel.this,MENU_ID);
    }

    public void setExitGame(GUIExit guiExit) {
        this.guiExit = guiExit;
    }

}
