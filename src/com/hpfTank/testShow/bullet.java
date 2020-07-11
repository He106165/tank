package com.hpfTank.testShow;

import java.awt.*;

public class bullet {
    private static  final  int SPEED =PropertyMgr.getInt("bulletSpeed");
    public static int WIDTH=ResourceMgr.bulletD.getWidth(),HEIGHT=ResourceMgr.bulletD.getHeight();
    private int x,y;
    private Dir dir;
    private boolean living =true;

    private Rectangle rectangle=new Rectangle();

    private Group group=Group.BAD ;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private  TankFrame tankFrame;


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

    public bullet(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
        this.group=group;
        rectangle.x=this.x;
        rectangle.y=this.y;
        rectangle.width=WIDTH;
        rectangle.height=HEIGHT;

    }

    public void paint(Graphics s){
        if(!living){
            tankFrame.bulletList.remove(this);
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


    //判断子弹和坦克相撞

    public void rectangle(TankInfo tankInfo){
        if(this.group==tankInfo.getGroup()) return;
/*        Rectangle bullet=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle tank=new Rectangle(tankInfo.getX(),tankInfo.getY(),tankInfo.WIDTH,tankInfo.HEIGHT);*/
        if(rectangle.intersects(tankInfo.getRectangle())){
            tankInfo.die();
            this.die();

            int bx=this.x+TankInfo.WIDTH/2 -Explode.WIDTH/2;
            int by=this.y+TankInfo.HEIGHT/2 -Explode.HEIGHT/2;
            tankFrame.explodes.add(new Explode(bx,by,tankFrame));
        }
    }

}
