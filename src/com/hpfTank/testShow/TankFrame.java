package com.hpfTank.testShow;

import com.hpfTank.AbstractFactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame  extends Frame {

    public static   final int GAME_WIDTH=PropertyMgr.getInt("gameWidth"),GAME_HEIGHT=PropertyMgr.getInt("gameHeight");
    //子弹
    public List<BaseBullet> bulletList=new ArrayList<BaseBullet>();

    //爆炸
    public List<BaseExpolad> explodes=new ArrayList<BaseExpolad>();

    //坦克
    public List<BaseTank> tanks=new ArrayList<>();

    TankInfo mainTank = new TankInfo(200,200,Dir.DOWN,this,Group.DOOG);


    public GameFactory factory=new RectFactory();
    //public GameFactory factory=new DefaultFactory();

    public   TankFrame (){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setTitle("坦克");
        setVisible(true);
        //窗口关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //键盘监听
        addKeyListener(new MyKetListener());
    }

    //双缓冲解决 屏幕闪烁
    //先画到内存里  直接放上去
    Image offScreenImage=null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage==null){
            offScreenImage=this.createImage(GAME_WIDTH,GAME_WIDTH);
        }else {
            Graphics graphics=offScreenImage.getGraphics();
            Color color = graphics.getColor();
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0,0,GAME_WIDTH,GAME_WIDTH);
            graphics.setColor(color);
            paint(graphics);
            g.drawImage(offScreenImage,0,0,null);
        }
    }

    @Override
    public void paint(Graphics s){
        Color color = s.getColor();
        s.setColor(Color.WHITE);
        s.drawString("子弹数量"+bulletList.size(),10,60);
        s.drawString("敌人数量"+tanks.size(),100,60);
        s.setColor(color);
        mainTank.paint(s);

        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(s);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(s);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(s);
        }


        //判断子弹和坦克相撞
        for (int i = 0; i <bulletList.size() ; i++){
            for (int j = 0; j < tanks.size(); j++)
                bulletList.get(i).rectangle(tanks.get(j));
        }
    }

    //键盘监听
    class MyKetListener extends KeyAdapter{
        boolean BL=false;
        boolean BR=false;
        boolean BU=false;
        boolean BD=false;


        //key 摁下去
        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_UP:
                    BU=true;
                    break;
                case KeyEvent.VK_LEFT:
                    BL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD=true;
                    break;
                default:
                    break;
            }
            mainTankDir();
        }


        //key弹出来
        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_UP:
                    BU=false;
                    break;
                case KeyEvent.VK_LEFT:
                    BL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR=false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD=false;
                    break;

                case  KeyEvent.VK_CONTROL:
                    mainTank.frie();
                    break;
                default:
                    break;
            }
            mainTankDir();
        }
        //坦克的方向
        public void mainTankDir(){
            //判断是不是移动了
            if(!BL && !BR && !BU &&!BD){
                mainTank.setMoving(false);
            }else{
                mainTank.setMoving(true);
                if(BL==true){
                    mainTank.setDir(Dir.LEFT);
                }
                if(BR==true){
                    mainTank.setDir(Dir.RIGHT);
                }
                if(BU==true) {
                    mainTank.setDir(Dir.UP);
                }
                if(BD==true){
                    mainTank.setDir(Dir.DOWN);
                }
            }
        }
    }

}
