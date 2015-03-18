/*
 * Copyright 2015 TheShark34
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package fr.theshark34.feelcraft;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * An image button, a JButton with an image on it, and an other when the mouse
 * is over it
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
@SuppressWarnings("serial")
public class ImageButton extends JButton implements MouseListener {

	// The button image
	private Icon image;

	// The button image when the mouse is over it
	private Icon imageHover;

	/**
	 * Simple constructor
	 * 
	 * @param image
	 *            The button image
	 * @param imageHover
	 *            The button image when the mouse is over it
	 */
	public ImageButton(String image, String imageHover) {
		// Setting the images
		this.image = new ImageIcon(ImageButton.class.getResource(image));
		this.imageHover = new ImageIcon(
				ImageButton.class.getResource(imageHover));

		// Setting the image as the button icon
		this.setIcon(this.image);

		// Adding this as a mouse listener
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// When the mouse enter in the button zone, setting the icon to the
		// second image
		this.setIcon(imageHover);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// When the mouse exit the button zone, setting he icon to the first
		// image
		this.setIcon(image);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
