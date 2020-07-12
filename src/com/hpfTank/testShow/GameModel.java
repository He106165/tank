package com.hpfTank.testShow;

import com.hpfTank.Collid.Collider;
import com.hpfTank.Collid.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    public GameModel() {

        int count=Integer.valueOf(PropertyMgr.get("initTankCount").toString());

        for (int i = 0; i < count; i++) {
            add(new TankInfo(80+i*80,80,Dir.DOWN,this,Group.BAD));
        }
    }
    ColliderChain collider=new ColliderChain();

//    //子弹
//    public List<bullet> bulletList=new ArrayList<bullet>();
//
//    //爆炸
//    public List<Explode> explodes=new ArrayList<Explode>();
//
//    //坦克
//    public List<TankInfo> tanks=new ArrayList<>();

    TankInfo mainTank = new TankInfo(200,200,Dir.DOWN,this,Group.DOOG);

    List<GameObject>  objects=new ArrayList<>();

    public TankInfo getMainTank() {
        return mainTank;
    }

    public void add(GameObject oj){
        this.objects.add(oj);
    }

    public void remove (GameObject oj){
        this.objects.remove(oj);
    }

    public void paint(Graphics s){
        Color color = s.getColor();
        s.setColor(Color.WHITE);
/*        s.drawString("子弹数量"+bulletList.size(),10,60);
        s.drawString("敌人数量"+tanks.size(),100,60);
        s.setColor(color);*/
        mainTank.paint(s);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(s);
        }

        for (int i = 0; i <objects.size() ; i++) {
            for (int j = i+1; j <objects.size() ; j++) {
                GameObject o1=objects.get(i);
                GameObject o2=objects.get(j);
                collider.collider(o1,o2);
            }
        }


        //判断子弹和坦克相撞
       /* for (int i = 0; i <bulletList.size() ; i++){
            for (int j = 0; j < tanks.size(); j++)
                bulletList.get(i).rectangle(tanks.get(j));
        }*/
    }
}
