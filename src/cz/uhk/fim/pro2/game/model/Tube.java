package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {

	private float positionX;
	private float height;
	private Color color;
	private boolean counted=false;
	
	private static final int GAP= 200;
	private static final int WIDTH = 50; 
	
	public Tube(float positionX, float height, Color color) {
		super();
		this.positionX = positionX;
		this.height = height;
		this.color = color;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		
		Rectangle topRectangle = getTopRectangle();
		g.fillRect(	(int)topRectangle.getX(),
					(int)topRectangle.getY(),
					(int)topRectangle.getWidth(),
					(int)topRectangle.getHeight());
		
		Rectangle bottomRectangle = getBottomRectangle();
		g.fillRect(	(int)bottomRectangle.getX(),
					(int)bottomRectangle.getY(),
					(int)bottomRectangle.getWidth(),
					(int)bottomRectangle.getHeight());
	}
	
	public Rectangle getTopRectangle(){
		return new Rectangle(
				(int)getPositionX()-(WIDTH/2),
				(int)height,
				WIDTH,
				(int)(MainFrame.HEIGHT - height));
	}
	
	public Rectangle getBottomRectangle(){
		return new Rectangle(
				(int)getPositionX()-(WIDTH/2),
				0,
				WIDTH,
				(int)(height - GAP));
	}
	
	
	public void update(float deltaTime){
		positionX -= World.SPEED * deltaTime;
	}
	
	public int getCenterY(){
		return (int)(height - GAP/2.0);
	}
	
	public int getMinX(){
		return (int) positionX - (WIDTH/2);	
	}
	
	public int getMaxX(){
		return (int) positionX + (WIDTH/2);	
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}

	public boolean isCounted() {
		return counted;
	}

	public void setCounted(boolean counted) {
		this.counted = counted;
	}
	
	
	

}
