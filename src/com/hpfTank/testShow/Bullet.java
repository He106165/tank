package com.hpfTank.testShow;

import java.awt.*;

public class Bullet extends  GameObject {
    private static  final  int SPEED =PropertyMgr.getInt("bulletSpeed");
    public static int WIDTH=ResourceMgr.bulletD.getWidth(),HEIGHT=ResourceMgr.bulletD.getHeight();
//    private int x,y;
    private Dir dir;
    private boolean living =true;

    public  Rectangle rectangle=new Rectangle();

    public Group group=Group.BAD ;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }



    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Bullet(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        rectangle.x=this.x;
        rectangle.y=this.y;
        rectangle.width=WIDTH;
        rectangle.height=HEIGHT;

        GameModel.getInstence().add(this);

    }

    public void paint(Graphics s){
        if(!living){
            GameModel.getInstence().remove(this);
        }
        switch (dir){
            case LEFT:
                s.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                s.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                s.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                s.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }
        move();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHIGH() {
        return HEIGHT;
    }


    public void move(){
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
        rectangle.x=this.x;
        rectangle.y=this.y;
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH ||y >TankFrame.GAME_HEIGHT) living =false;
    }
    public void die(){
        this.living =false;
    }





}
