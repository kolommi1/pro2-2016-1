package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen {
	
	private long lastTimeMillis;
	
	private Timer timer;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		//WORLD	
		Bird bird = new Bird("Flappy", 240, 400);
		
		World world = new World(bird);
		world.addTubet(new Tube(400, 400, Color.green));
		world.addTubet(new Tube(600, 300, Color.green));
		world.addTubet(new Tube(800, 500, Color.green));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		GameCanvas gamecanvas = new GameCanvas(world);
		add(gamecanvas);
		gamecanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);

		timer = new Timer(20,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis)/1000f; 
				System.out.println(delta);
				world.update(delta);
				gamecanvas.repaint();
				lastTimeMillis = currentTimeMillis;
			}
		});
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

}
