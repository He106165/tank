package com.hpfTank.Collid;

import com.hpfTank.testShow.GameObject;
import com.hpfTank.testShow.TankInfo;
import com.hpfTank.testShow.Bullet;

public class TankAndBulletCollider implements  Collider{
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof TankInfo){
            Bullet bullet=(Bullet) o1;
            TankInfo tankInfo=(TankInfo) o2;
            if(bullet.rectangle(tankInfo)){
                return  true;
            }
        }else if(o2 instanceof Bullet && o1 instanceof TankInfo){
            return collider(o2,o1);
        }


        return true;
    }
}
