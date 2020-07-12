package com.hpfTank.decorator;

import com.hpfTank.testShow.GameObject;

import java.awt.*;

public abstract   class GODecorator extends GameObject {
    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public abstract void paint(Graphics g);
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHIGH() {
        return 0;
    }
}
