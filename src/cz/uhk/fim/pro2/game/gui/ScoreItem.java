package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {
	private JLabel jLabelIndex, jLabelScore;
	
	public ScoreItem (int index, int score){
		jLabelIndex = new JLabel(index + ".");
		jLabelScore = new JLabel(String.valueOf(score));
		
		jLabelIndex.setBounds(0, 0, 100, 50);
		jLabelIndex.setFont(new Font("Arial", Font.PLAIN, 20));
		
		jLabelScore.setBounds(50, 0, 200, 50);
		jLabelScore.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(jLabelIndex);		
		add(jLabelScore);
	}
}
