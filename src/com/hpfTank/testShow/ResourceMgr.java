package com.hpfTank.testShow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage GoogTankL,GoogTankR,GoogTankU,GoogTankD;
    public static BufferedImage BadTankL,BadTankR,BadTankU,BadTankD;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] exploads=new BufferedImage[16];
    static {
        try {
            BadTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            BadTankL= ImageUtil.rorateImage(BadTankU,-90);
            BadTankR= ImageUtil.rorateImage(BadTankU,90);
            BadTankD= ImageUtil.rorateImage(BadTankU,180);
            GoogTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            GoogTankL= ImageUtil.rorateImage(GoogTankU,-90);
            GoogTankR= ImageUtil.rorateImage(GoogTankU,90);
            GoogTankD= ImageUtil.rorateImage(GoogTankU,180);

            bulletL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            for(int i=0; i<16; i++)
                exploads[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
