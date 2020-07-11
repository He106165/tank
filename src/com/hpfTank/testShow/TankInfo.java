package com.hpfTank.testShow;

import java.awt.*;
import java.util.Random;

public class TankInfo {
    private int x,y;
    private Dir dir;
    private static  final  int SPEED =PropertyMgr.getInt("tankSpeed");

    private Group group;


    private boolean  living=true;

    public static int WIDTH=ResourceMgr.GoogTankD.getWidth(),HEIGHT=ResourceMgr.GoogTankD.getHeight();

    private boolean moving=true;

    private TankFrame tankFrame;

    private Random random=new Random();

    private Rectangle rectangle=new Rectangle();


    public Dir getDir() {
        return dir;
    }




    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public TankInfo(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        super();
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics s){
        if(!living) tankFrame.tanks.remove(this);
        //根据方向显示图片
        switch (dir){
            case LEFT:
                s.drawImage(this.group==Group.BAD?ResourceMgr.BadTankL :ResourceMgr.GoogTankL,x,y,null);
                break;
            case UP:
                s.drawImage(this.group==Group.BAD?ResourceMgr.BadTankU :ResourceMgr.GoogTankU,x,y,null);

                break;
            case RIGHT:
                s.drawImage(this.group==Group.BAD?ResourceMgr.BadTankR :ResourceMgr.GoogTankR,x,y,null);

                break;
            case DOWN:
                s.drawImage(this.group==Group.BAD?ResourceMgr.BadTankD :ResourceMgr.GoogTankD,x,y,null);

                break;
                default:break;
        }
        move();

    }
    public void move(){
        if(!moving) return ;

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
                default:
                    break;
        }



        if(this.group==Group.BAD && random.nextInt(100) > 95){
            this.frie();
        }
        if(this.group==Group.BAD && random.nextInt(100) > 95){
            rendomDir();
        }
        boundsCheck();
        rectangle.x=this.x;
        rectangle.y=this.y;

    }

    private void rendomDir(){

        this.dir=Dir.values()[random.nextInt(4)];
    }

    //发射一个子弹
    public void frie(){
        int bx=this.x+TankInfo.WIDTH/2 -bullet.WIDTH/2;
        int by=this.y+TankInfo.HEIGHT/2 -bullet.HEIGHT/2;
        tankFrame.bulletList.add(new bullet(bx,by, this.dir,this.tankFrame,this.group));
    }

    public void die(){
        this.living=false;
    }

    private void boundsCheck(){
        if(this.x<2) x=2;
        else if(this.y <30) y=30;
        else if(this.x> tankFrame.GAME_WIDTH-TankInfo.WIDTH-2) x=tankFrame.GAME_WIDTH-TankInfo.WIDTH-2;
        else if(this.y> tankFrame.GAME_HEIGHT-TankInfo.HEIGHT-2) y=tankFrame.GAME_HEIGHT-TankInfo.HEIGHT-2;
    }

}
