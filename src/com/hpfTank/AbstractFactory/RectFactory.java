package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.Dir;
import com.hpfTank.testShow.Group;
import com.hpfTank.testShow.TankFrame;

public class RectFactory extends GameFactory{
    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        return new Rectbullet(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseExpolad creatExpolad(int x, int y, TankFrame tankFrame) {
        return new RectExpolad(x,y,tankFrame);
    }
}
