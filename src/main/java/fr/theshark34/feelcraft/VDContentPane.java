package fr.theshark34.feelcraft;

import java.awt.Graphics;

import javax.swing.JDesktopPane;

public class VDContentPane extends JDesktopPane {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(PackLoader.getBackground(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
