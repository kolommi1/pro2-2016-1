package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends JPanel {
	private World world;
	
	private BufferedImage imageBird, imageHeart, imageBackground, imageBottom, imageTube, imageTop;
	
	public static int UP_BOUND = 100;
	public static int DOWN_BOUND = 70;
	
	private int background_x = 0, background_x2 = MainFrame.WIDTH;
	private static int BACKGROUND_LIMIT = 0-MainFrame.WIDTH;
	
	
	public GameCanvas(World world) {
		this.world=world;
		
		try {		
			imageBird = ImageIO.read(new File("assets/bird.png"));
			imageHeart = ImageIO.read(new File("assets/heart.png"));
			imageBackground = ImageIO.read(new File("assets/background.png"));
			imageBottom = ImageIO.read(new File("assets/bottom.png"));
			imageTube = ImageIO.read(new File("assets/tube.png"));
			imageTop = ImageIO.read(new File("assets/top.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.cyan);
		g.drawImage(imageBackground,background_x, UP_BOUND, MainFrame.WIDTH, MainFrame.HEIGHT-DOWN_BOUND,null);
		g.drawImage(imageBackground,background_x2, UP_BOUND, MainFrame.WIDTH, MainFrame.HEIGHT-DOWN_BOUND,null);
		background_x--;
		if(background_x<BACKGROUND_LIMIT){
			background_x = MainFrame.WIDTH-10;
		}		
		background_x2--;
		if(background_x2<BACKGROUND_LIMIT){
			background_x2 = MainFrame.WIDTH-10;
		}
		
		Bird bird = world.getBird();
		bird.paint(g,imageBird);
				
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts){
			heart.paint(g, imageHeart);	
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes){
			tube.paint(g, imageTube);			
		}
		
		g.setColor(Color.ORANGE);
		g.drawImage(imageTop,0, 0, MainFrame.WIDTH, UP_BOUND, null);
		g.setColor(Color.BLACK);
		g.drawImage(imageBottom,0, MainFrame.HEIGHT-DOWN_BOUND, MainFrame.WIDTH, DOWN_BOUND, null);		
		
	}
}
