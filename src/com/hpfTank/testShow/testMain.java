package com.hpfTank.testShow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testMain {
    public static void  main (String[] arg) throws  Exception{

        TankFrame frame=new TankFrame();


        while (true){
            Thread.sleep(50);
            frame.repaint();
        }

    }
}
