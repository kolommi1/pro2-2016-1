package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen{
	
	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		for (int i = 0; i < ScoreManager.size(); i++) {
			System.out.println(ScoreManager.get(i));
						
		}
		
		JButton jButtonBack = new JButton("BACK");
		
		jButtonBack.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 8));
		
		
		for (int i = 0; i < ScoreManager.size(); i++) {
			int score = ScoreManager.get(i);
			ScoreItem scoreItem = new ScoreItem(i+1,  score);
			scoreItem.setBounds(40,200+i*50,400,50);
			add(scoreItem);
		}
		
		add(jButtonBack);
	}

}
