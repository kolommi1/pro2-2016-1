package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeScreen extends Screen {
	
	public HomeScreen (MainFrame mainFrame) {
		super(mainFrame);
		
		JButton jButtonPlay = new JButton("PLAY");	
		JButton jButtonScore = new JButton("SCORE");	
		JButton jButtonMute = new JButton("MUTE");
		JLabel jLabelTitle = new JLabel("FIM BIRD");
		
		jButtonPlay.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//co se stane kdyz na tohle tlacitko kliknu
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
			}
		});
		
		jLabelTitle.setFont(new Font("Arial",Font.BOLD, 40));
		jLabelTitle.setForeground(Color.black);
		
		//nastavím velikost a pozici
		jLabelTitle.setBounds(40, 80, 400, 50);
		jButtonPlay.setBounds(100, 400, 280, 50);
		jButtonMute.setBounds(100, 460, 280, 50);
		jButtonScore.setBounds(100, 520, 280, 50);
		
		add(jLabelTitle);
		add(jButtonPlay);
		add(jButtonScore);
		add(jButtonMute);
	
		
	}
	

	
	

}
