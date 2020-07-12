package com.hpfTank.Collid;

import com.hpfTank.testShow.Bullet;
import com.hpfTank.testShow.GameObject;
import com.hpfTank.testShow.TankInfo;

public class TankAndTankCollider implements   Collider{
    //俩个坦克相撞
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof TankInfo && o2 instanceof TankInfo){
            TankInfo tankInfo2=(TankInfo) o1;
            TankInfo tankInfo=(TankInfo) o2;
            if(tankInfo2.getRectangle().intersects(tankInfo.getRectangle())){
                tankInfo2.trunBack();
                tankInfo.trunBack();
            }
        }
        return false;
    }
}
