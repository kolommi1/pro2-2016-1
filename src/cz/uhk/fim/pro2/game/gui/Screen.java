package cz.uhk.fim.pro2.game.gui;

import javax.swing.JPanel;

public abstract class Screen extends JPanel {
	protected MainFrame mainframe;
	
	public Screen(MainFrame mainframe){
		this.mainframe = mainframe;
	}
}
