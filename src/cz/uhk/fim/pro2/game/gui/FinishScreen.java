package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen{

	public FinishScreen(MainFrame mainFrame,World world) {
		super(mainFrame);
		int score =  world.getBird().getScore();
		
		ScoreManager.putScore(score);
		
		JLabel jLabelScore = new JLabel("Score: " + score);
		JButton jButtonTryAgain = new JButton("Try Againg");
		JButton jButtonScore = new JButton("High Score");
		
		jButtonTryAgain.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		jLabelScore.setBounds(		MainFrame.WIDTH/2-50, MainFrame.HEIGHT/2-130, 100, 60);
		jButtonTryAgain.setBounds(	MainFrame.WIDTH/2+50, MainFrame.HEIGHT/2-30, 100, 40);
		jButtonScore.setBounds(	MainFrame.WIDTH/2-150, MainFrame.HEIGHT/2-30, 100, 40);
		
		jLabelScore.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(jLabelScore);
		add(jButtonTryAgain);
		add(jButtonScore);
		
		
	}

}
