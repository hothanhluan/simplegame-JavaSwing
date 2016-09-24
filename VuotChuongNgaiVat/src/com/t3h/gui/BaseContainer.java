package com.t3h.gui;

import javax.swing.*;

public abstract class BaseContainer extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BaseContainer() {
        initContainer();
        intiComps();
        addComps();
    }

    public abstract void initContainer();

    public abstract void intiComps();

    public abstract void addComps();
}
