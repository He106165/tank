package com.hpfTank.AbstractFactory;

import com.hpfTank.testShow.*;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank {
    public  int x,y;
    public Dir dir;
    private static  final  int SPEED =PropertyMgr.getInt("tankSpeed");

    public Group group;


    private boolean  living=true;

    public static int WIDTH=ResourceMgr.GoogTankD.getWidth(),HEIGHT=ResourceMgr.GoogTankD.getHeight();

    private boolean moving=true;

    public TankFrame tankFrame;

    private Random random=new Random();

    private Rectangle rectangle=new Rectangle();


    public Dir getDir() {
        return dir;
    }


    //FristStrategy fristStrategy = new DefaultFristStrategy();

    FristStrategy fristStrategy;

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public RectTank(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
        this.group=group;
        rectangle.x=this.x;
        rectangle.y=this.y;
        rectangle.width=WIDTH;
        rectangle.height=HEIGHT;
        try {
            if(group==Group.DOOG) {
                String  goodFS=(String)PropertyMgr.get("goodFS");
                fristStrategy=(FristStrategy)Class.forName(goodFS).getDeclaredConstructor().newInstance();
            }else{
                String badFS=(String)PropertyMgr.get("badFS");
                fristStrategy=(FristStrategy)Class.forName(badFS).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    @Override
    public void paint(Graphics s){
        if(!living) tankFrame.tanks.remove(this);
        Color color = s.getColor();
        s.setColor(group==Group.DOOG ? Color.green :Color.red);
        s.fillRect(x,y,30,30);
        s.setColor(color);

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
        //    this.frie();
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
        Dir[] dirs=Dir.values();
        for (Dir dir : dirs) {
            tankFrame.factory.creatBullet(bx,by, dir,tankFrame,group);

        }
        if(this.group==Group.DOOG)
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
    }

    public void die(){
        this.living=false;
    }

    private void boundsCheck(){
        if(this.x<2) x=2;
        else if(this.y <30) y=30;
        else if(this.x> tankFrame.GAME_WIDTH- RectTank.WIDTH-2) x=tankFrame.GAME_WIDTH- RectTank.WIDTH-2;
        else if(this.y> tankFrame.GAME_HEIGHT- RectTank.HEIGHT-2) y=tankFrame.GAME_HEIGHT- RectTank.HEIGHT-2;
    }

}
