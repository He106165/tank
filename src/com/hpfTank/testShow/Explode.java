package com.hpfTank.testShow;

import com.hpfTank.AbstractFactory.BaseExpolad;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode  extends BaseExpolad {
	public static int WIDTH = ResourceMgr.exploads[0].getWidth();
	public static int HEIGHT = ResourceMgr.exploads[0].getHeight();
	
	private int x, y;

	private TankFrame tankFrame;
	
	//private boolean living = true;
	
	private int step = 0;
	
	public Explode(int x, int y, TankFrame tankFrame) {
		this.x = x;
		this.y = y;
		this.tankFrame=tankFrame;
/*
		new Thread(()->new Audio("audio/explode.wav").play()).start();
*/
	}
	
	

	public void paint(Graphics g) {
		
		g.drawImage(ResourceMgr.exploads[step++], x, y, null);

		if(step >= ResourceMgr.exploads.length)
			tankFrame.explodes.remove(this);

		
	}
	
	

}
