package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.Dir;
import com.hpfTank.testShow.Group;
import com.hpfTank.testShow.TankFrame;

public abstract class GameFactory {


    public abstract  BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract  BaseBullet creatBullet(int x,int y,Dir dir,TankFrame tankFrame,Group group);

    public abstract  BaseExpolad creatExpolad(int x,int y,TankFrame tankFrame);
}
