package cz.uhk.fim.pro2.game.gui;

import javax.swing.JPanel;

public abstract class Screen extends JPanel {
	protected MainFrame mainframe;
	private String title; 
	
	public Screen(MainFrame mainframe, String title){
		this.mainframe = mainframe;
		this.title = title;
	}
	
	public String getTitle() {
		return title;		
	}
}
