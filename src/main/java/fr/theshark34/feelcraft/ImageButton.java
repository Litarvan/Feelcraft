package fr.theshark34.feelcraft;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ImageButton extends JButton implements MouseListener {

	private Icon image;
	private Icon imageHover;
	
	public ImageButton(String image, String imageHover) {
		this.image = new ImageIcon(ImageButton.class.getResource(image));
		this.imageHover = new ImageIcon(ImageButton.class.getResource(imageHover));
		this.setIcon(this.image);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setIcon(imageHover);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {		
		this.setIcon(image);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {		
	}
	
}
