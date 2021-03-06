package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import cz.uhk.fim.pro2.game.gui.GameCanvas;
import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Bird {
	
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIFES = 3;
	public static final int JUMP = 500;
	
	private static final int GRAVITY = 300;

	private String name;
	private float positionX, positionY;
	private float speed;
	private int lifes;
	private int score;

	public Bird(String name, float positonX, float positionY) {
		super();
		this.name=name;
		this.positionX=positonX;
		this.positionY=positionY;		
		speed = JUMP/2;
		lifes = DEFAULT_LIFES;
		score = DEFAULT_SCORE;		
	}
	
	public void paint(Graphics g, BufferedImage image){
		g.setColor(Color.BLUE);
		
		Rectangle rectangle = getRectangle();
		if(image == null){
		g.fillRect(	(int)rectangle.getX(),
					(int)rectangle.getY(),
					(int)rectangle.getWidth(),
					(int)rectangle.getHeight());
		}
		else {
			g.drawImage(
		
				image,
				(int)rectangle.getX(),
				(int)rectangle.getY(),
				(int)rectangle.getWidth(),
				(int)rectangle.getHeight(),
				null
			);
		}
	}
	
	public Rectangle getRectangle(){
		return new Rectangle((int)getPositionX() -25, (int)getPositionY() -25, 50, 50);	
	}
	
	public void update(float deltaTime){
		positionY -= speed* deltaTime;
		positionY += GRAVITY * deltaTime;
		
		speed -= speed * deltaTime;
	}
	
	public boolean collideWith(Tube tube){
		Rectangle rectangle = getRectangle();		
		return rectangle.intersects(tube.getBottomRectangle()) || rectangle.intersects(tube.getTopRectangle());
	}
	
	public boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	
	public boolean isOutOf(){
		Rectangle rectangle = getRectangle();
		
		int upLimit = GameCanvas.UP_BOUND;
		int downLimit =MainFrame.HEIGHT - GameCanvas.DOWN_BOUND;
		
		return (rectangle.getMinY() < upLimit || rectangle.getMaxY() > downLimit);
	}
	
	public void goUp(){
		speed = JUMP;
		try {			
			File soundFile = new File("assets/flap.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);			
			Clip clip = AudioSystem.getClip();		
			clip.open(audioInputStream);
			
			clip.start();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void catchHeart(){
		lifes++;
	}
		
	public void addPoint(){
		score++;		
	}
	
	public boolean isAlive(){
		return lifes > 0;
	}
	
	public void removeLife(){
		lifes--;
	}
	
	public String getName(){
		return name;
	}
	
		public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
