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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

/**
 * This is a Simple JLabel with Antialiasing in the paintComponent method. It
 * has only the simple construtor with a string as argument
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class AntialiasLabel extends JLabel {

	/**
	 * Juste the simple constructor
	 * 
	 * @param text
	 *            The JLabel text
	 */
	public AntialiasLabel(String text) {
		super(text);
	}

	/**
	 * Paints the label with antialiasing
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		super.paintComponent(g2d);
	}

}
