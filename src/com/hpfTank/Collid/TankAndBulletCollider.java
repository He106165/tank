package com.hpfTank.Collid;

import com.hpfTank.testShow.*;

public class TankAndBulletCollider implements  Collider{
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof TankInfo){
            Bullet bullet=(Bullet) o1;
            TankInfo tankInfo=(TankInfo) o2;
            if(bullet.group==tankInfo.getGroup()) return false;
            if(bullet.rectangle.intersects(tankInfo.getRectangle())){
                tankInfo.die();
                bullet.die();
                int bx=tankInfo.getX()+TankInfo.WIDTH/2 - Explode.WIDTH/2;
                int by=tankInfo.getY()+TankInfo.HEIGHT/2 -Explode.HEIGHT/2;
                new Explode(bx,by);
                return false;
            }
        }else if(o2 instanceof Bullet && o1 instanceof TankInfo){
            return collider(o2,o1);
        }
        return true;
    }
}
