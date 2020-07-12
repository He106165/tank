package com.hpfTank.Collid;

import com.hpfTank.testShow.GameObject;
import com.hpfTank.testShow.TankInfo;
import com.hpfTank.testShow.Wall;

public class TankAndWallCollider implements   Collider{
    //俩个坦克相撞
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof TankInfo && o2 instanceof Wall){
            TankInfo tankInfo2=(TankInfo) o1;
            Wall wall=(Wall) o2;
            if(tankInfo2.getRectangle().intersects(wall.rectangle)){
                tankInfo2.trunBack();
            }
        }
        return true;
    }
}
