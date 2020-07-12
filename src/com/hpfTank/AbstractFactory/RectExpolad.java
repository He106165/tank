package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.Audio;
import com.hpfTank.testShow.ResourceMgr;
import com.hpfTank.testShow.TankFrame;

import java.awt.*;

public class RectExpolad extends BaseExpolad{
    public static int WIDTH = ResourceMgr.exploads[0].getWidth();
    public static int HEIGHT = ResourceMgr.exploads[0].getHeight();

    private int x, y;

    public TankFrame tankFrame;

    //private boolean living = true;

    private int step = 0;

    public  RectExpolad(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame=tankFrame;

		new Thread(()->new Audio("audio/explode.wav").play()).start();

    }


    @Override
    public void paint(Graphics g) {

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
//        g.drawImage(ResourceMgr.exploads[step++], x, y, null);
        step++;
        if(step >= 5)
            tankFrame.explodes.remove(this);
        g.setColor(color);

    }
}
