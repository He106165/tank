package com.hpfTank.testShow;

public class DefaultFristStrategy2 implements FristStrategy{
    @Override
    public void fire(TankInfo tankInfo) {
        int bx=tankInfo.x+TankInfo.WIDTH/2 -Bullet.WIDTH/2;
        int by=tankInfo.y+TankInfo.HEIGHT/2 -Bullet.HEIGHT/2;

        Dir[] dirs=Dir.values();
        for (Dir dir : dirs) {
            //这种是有bug的，加了俩次
            GameModel.getInstence().add(new Bullet(bx,by, dir,tankInfo.group));
            //new Bullet(bx,by, dir,tankInfo.group);

        }
        //new bullet(bx,by, tankInfo.dir,tankInfo.tankFrame,tankInfo.group);
        if(tankInfo.group==Group.DOOG)
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
