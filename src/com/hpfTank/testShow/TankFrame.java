package com.hpfTank.testShow;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame  extends Frame {

    public static   final int GAME_WIDTH=PropertyMgr.getInt("gameWidth"),GAME_HEIGHT=PropertyMgr.getInt("gameHeight");

    GameModel gameModel=GameModel.getInstence();

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
        gameModel.paint(s);
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
                    gameModel.getMainTank().headleFrieKey();
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
                gameModel.getMainTank().setMoving(false);
            }else{
                gameModel.getMainTank().setMoving(true);
                if(BL==true){
                    gameModel.getMainTank().setDir(Dir.LEFT);
                }
                if(BR==true){
                    gameModel.getMainTank().setDir(Dir.RIGHT);
                }
                if(BU==true) {
                    gameModel.getMainTank().setDir(Dir.UP);
                }
                if(BD==true){
                    gameModel.getMainTank().setDir(Dir.DOWN);
                }
            }
        }
    }

}
