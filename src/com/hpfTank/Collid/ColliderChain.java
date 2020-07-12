package com.hpfTank.Collid;

import com.hpfTank.testShow.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ColliderChain  implements Collider{

    public List<Collider> colliders=new ArrayList<>();

    public ColliderChain() {

        colliders.add(new TankAndBulletCollider());
        colliders.add(new TankAndTankCollider());
        colliders.add(new BulletWallCollider());
        colliders.add(new TankAndWallCollider());
    }
    public void add(Collider c){
        colliders.add(c);
    }
    public void move(Collider c){
        colliders.remove(c);
    }

    public boolean collider(GameObject o1, GameObject o2) {
        for (Collider collider : colliders) {
            if(!collider.collider(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
