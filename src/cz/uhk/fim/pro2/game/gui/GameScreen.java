package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainframe) {
		super(mainframe, "Game");

		JButton buttonBack = new JButton("BACK");
		JButton buttonPause = new JButton("PAUSE");
		
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setScreen(new HomeScreen(mainframe));
			}
		});
				
		add(buttonBack);
		add(buttonPause);
	}

}
