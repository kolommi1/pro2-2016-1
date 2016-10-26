package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {

	public ScoreScreen(MainFrame mainframe) {
		super(mainframe, "Score");

		JButton buttonBack = new JButton("BACK");
		
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setScreen(new HomeScreen(mainframe));
			}
		});
				
				
		add(buttonBack);
	}

}
