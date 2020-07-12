package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.Group;

import java.awt.*;

public abstract class BaseTank {

    public Group group;
    public  Rectangle rectangle=new Rectangle();
    public Group getGroup() {
        return group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public abstract void paint(Graphics s);

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
