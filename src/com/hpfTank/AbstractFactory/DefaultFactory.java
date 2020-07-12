package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.*;

public class DefaultFactory extends   GameFactory{

    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new TankInfo(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseBullet creatBullet(int x, int y,Dir dir, TankFrame tankFrame,Group group) {
        return new bullet(x,y,dir,tankFrame,group);
    }

    @Override
    public BaseExpolad creatExpolad(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }
}
