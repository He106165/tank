package com.hpfTank.testShow;

import com.hpfTank.decorator.TailDecorator;
import com.hpfTank.decorator.RactDecorator;

public class DefaultFristStrategy  implements FristStrategy{
    @Override
    public void fire(TankInfo tankInfo) {
        int bx=tankInfo.x+TankInfo.WIDTH/2 -Bullet.WIDTH/2;
        int by=tankInfo.y+TankInfo.HEIGHT/2 -Bullet.HEIGHT/2;
        GameModel.getInstence().add(
                new RactDecorator(
                        new TailDecorator(
                        new Bullet(bx,by, tankInfo.dir,tankInfo.group))));

        //new Bullet(bx,by, tankInfo.dir,tankInfo.group);
        if(tankInfo.group==Group.DOOG)
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
    }
}
