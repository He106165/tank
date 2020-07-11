package com.hpfTank.testShow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testMain {
    public static void  main (String[] arg) throws  Exception{

        TankFrame frame=new TankFrame();
        int count=Integer.valueOf(PropertyMgr.get("initTankCount").toString());

        for (int i = 0; i < count; i++) {
            frame.tanks.add(new TankInfo(80+i*40,80,Dir.DOWN,frame,Group.BAD));
        }

        while (true){
            Thread.sleep(50);
            frame.repaint();
        }

    }
}
