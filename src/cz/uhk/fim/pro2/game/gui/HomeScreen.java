package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeScreen extends Screen {

	public HomeScreen(MainFrame mainframe) {
		super(mainframe, "Home");
		
		JButton buttonPlay = new JButton("PLAY");
		JButton buttonScore = new JButton("SCORE");
		JButton buttonSound = new JButton("SOUND");
		
		buttonPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setScreen(new GameScreen(mainframe));				
			}
		});
		
		buttonScore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setScreen(new ScoreScreen(mainframe));
			}
		});

		buttonSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// vypni zvuk
			}
		});
		
		add(buttonPlay);
		add(buttonScore);
		add(buttonSound);
	}

}
