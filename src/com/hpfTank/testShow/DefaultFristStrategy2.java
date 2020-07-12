package com.hpfTank.testShow;

public class DefaultFristStrategy2 implements FristStrategy{
    @Override
    public void fire(TankInfo tankInfo) {
        int bx=tankInfo.x+TankInfo.WIDTH/2 -bullet.WIDTH/2;
        int by=tankInfo.y+TankInfo.HEIGHT/2 -bullet.HEIGHT/2;

        Dir[] dirs=Dir.values();
        for (Dir dir : dirs) {
            tankInfo.tankFrame.factory.creatBullet(bx,by, dir,tankInfo.tankFrame,tankInfo.group);

        }
        //new bullet(bx,by, tankInfo.dir,tankInfo.tankFrame,tankInfo.group);
        if(tankInfo.group==Group.DOOG)
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}