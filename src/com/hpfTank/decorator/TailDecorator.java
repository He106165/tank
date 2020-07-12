package com.hpfTank.decorator;

import com.hpfTank.testShow.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator{
    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        this.x=gameObject.x;
        this.y=gameObject.y;
        gameObject.paint(g);

        Color color=g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(super.gameObject.x,super.gameObject.y,super.gameObject.x+getWidth(),super.gameObject.y+getHIGH());
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
