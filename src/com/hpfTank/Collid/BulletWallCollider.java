package com.hpfTank.Collid;

import com.hpfTank.testShow.Bullet;
import com.hpfTank.testShow.GameObject;
import com.hpfTank.testShow.TankInfo;
import com.hpfTank.testShow.Wall;

public class BulletWallCollider implements  Collider{
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet=(Bullet) o1;
            Wall wall=(Wall) o2;
            if(bullet.rectangle.intersects(wall.rectangle)){
                bullet.die();
            }
        }else if(o2 instanceof Bullet && o1 instanceof Wall){
            return collider(o2,o1);
        }
        return true;
    }
}
