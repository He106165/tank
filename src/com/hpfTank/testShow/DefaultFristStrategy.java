package com.hpfTank.testShow;

public class DefaultFristStrategy  implements FristStrategy{
    @Override
    public void fire(TankInfo tankInfo) {
        int bx=tankInfo.x+TankInfo.WIDTH/2 -Bullet.WIDTH/2;
        int by=tankInfo.y+TankInfo.HEIGHT/2 -Bullet.HEIGHT/2;

        new Bullet(bx,by, tankInfo.dir,tankInfo.gameModel,tankInfo.group);
        if(tankInfo.group==Group.DOOG)
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
    }
}
