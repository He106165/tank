package com.hpfTank.testShow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testMain {
    public static void  main (String[] arg) throws  Exception{

        TankFrame frame=new TankFrame();
        int count=Integer.valueOf(PropertyMgr.get("initTankCount").toString());

        for (int i = 0; i < count; i++) {
            frame.tanks.add(frame.factory.creatTank(80+i*40,80,Dir.DOWN,Group.BAD,frame));

        }

        while (true){
            Thread.sleep(50);
            frame.repaint();
        }

    }
}
