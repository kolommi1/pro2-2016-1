package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.interfacer.WorldListener;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen implements WorldListener {
	
	private long lastTimeMillis;
	
	private Timer timer;
	private Bird bird;
	private JLabel jLabelScore, jLabelLifes;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()){ 
					timer.stop();
				}
				else {
					lastTimeMillis= System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial",Font.PLAIN, 8));
		jButtonPause.setBounds(400, 20, 60, 60);
		jButtonPause.setFont(new Font("Arial",Font.PLAIN, 8));
		
		add(jButtonPause);
		add(jButtonBack);
		
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		jLabelLifes = new JLabel("Lives: " + Bird.DEFAULT_LIFES);
		
		jLabelLifes.setBounds(260, 20, 120, 60);
		jLabelScore.setBounds(100, 20, 120, 60);
		
		add(jLabelLifes);
		add(jLabelScore);
		
		//WORLD	
		bird = new Bird("Flappy", 240, 400);
		
		World world = new World(bird, this);
		world.addTubet(new Tube(400, 400, Color.green));
		world.addTubet(new Tube(600, 300, Color.green));
		world.addTubet(new Tube(800, 500, Color.green));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		GameCanvas gamecanvas = new GameCanvas(world);
		add(gamecanvas);
		gamecanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		gamecanvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
			}
		});
		

		timer = new Timer(20,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis)/1000f;
				world.update(delta);
				
				jLabelLifes.setText("Lifes: " + bird.getLifes());
				jLabelScore.setText("Score: " + bird.getScore());
				
				if(!bird.isAlive()){
					timer.stop();
				}
				
				gamecanvas.repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

	@Override
	public void crashTube(Tube tube) {
		bird.removeLife();
		bird.setPositionY(tube.getCenterY());
	}

	@Override
	public void catchHeart(Heart heart) {
		heart.setPositionX(-100);
		bird.catchHeart();	
	}

	@Override
	public void outOf() {
		bird.setPositionY(MainFrame.HEIGHT / 2);
		bird.setSpeed(Bird.JUMP / 2);
		
		bird.removeLife();
	}

}
