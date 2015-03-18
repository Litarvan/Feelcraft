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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The Splash Frame - A little frame with a centered image that is displayed
 * when transforming Minecraft, and hid when the virtual desktop is showed. The
 * size of it is the same size of the splash image in the server-pack.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class Splash extends JFrame {

	/**
	 * The current Splash instance
	 */
	private static Splash instance;

	/**
	 * The splash image
	 */
	private JLabel splash;

	/**
	 * Creates a splash
	 */
	public Splash() {
		instance = this;

		this.setTitle("Feelcraft");
		this.setUndecorated(true);
		this.setSize(PackLoader.getSplash().getWidth(this), PackLoader
				.getSplash().getHeight(this));
		this.setLocationRelativeTo(null);

		splash = new JLabel(new ImageIcon(PackLoader.getSplash()));
		this.add(splash);

		this.setVisible(true);
	}

	/**
	 * Hides the splash, called by the VirtualDesktop when it is initializing
	 */
	static void hideSplash() {
		instance.setVisible(false);
	}

}
