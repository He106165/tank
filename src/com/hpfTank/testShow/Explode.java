package com.hpfTank.testShow;


import java.awt.Graphics;

public class Explode extends GameObject {
	public static int WIDTH = ResourceMgr.exploads[0].getWidth();
	public static int HEIGHT = ResourceMgr.exploads[0].getHeight();
	
	private int x, y;


	public GameModel gameModel;
	
	//private boolean living = true;
	
	private int step = 0;
	
	public Explode(int x, int y, GameModel gameModel) {
		this.x = x;
		this.y = y;
		this.gameModel=gameModel;
/*
		new Thread(()->new Audio("audio/explode.wav").play()).start();
*/
	}
	
	

	public void paint(Graphics g) {
		
		g.drawImage(ResourceMgr.exploads[step++], x, y, null);

		if(step >= ResourceMgr.exploads.length)
			gameModel.objects.remove(this);

		
	}
	
	

}
