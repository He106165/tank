package com.hpfTank.decorator;

import com.hpfTank.testShow.GameObject;

import java.awt.*;

public class RactDecorator  extends GODecorator{
    public RactDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);

        Color color=g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(super.gameObject.x,super.gameObject.y,super.gameObject.getWidth()+5,super.gameObject.getWidth()+5);
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHIGH() {
        return super.gameObject.getHIGH();
    }
}
