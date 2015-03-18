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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;

/**
 * The Feelcraft To Bar - This is the top bar of the virtual desktop. It is a
 * black JPanel with a GroupLayout, some buttons, and the server title in the
 * middle.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class FeelcraftTopBar extends JPanel {

	/**
	 * The Title, an antialias-label
	 */
	private AntialiasLabel title;

	/**
	 * The red close button
	 */
	private ImageButton close;

	/**
	 * The fullscreen button
	 */
	private ImageButton fullscreen;

	/**
	 * The hide button
	 */
	private ImageButton hide;

	/**
	 * The parent virtual desktop given in the constructor, used to call his
	 * fullscreen() method when clicking on the fullscreen button
	 */
	private VirtualDesktop parentFrame;

	/**
	 * Simple constructor, just initialize the bar
	 * 
	 * @param parentFrame
	 *            The parent virtual desktop given in the constructor, used to
	 *            call his fullscreen() method when clicking on the fullscreen
	 *            button
	 */
	public FeelcraftTopBar(VirtualDesktop parentFrame) {
		// Setting the parrent frame
		this.parentFrame = parentFrame;

		// Setting the background to black
		this.setBackground(Color.BLACK);

		// Initializing the title, an antialias label with the server name as
		// text
		title = new AntialiasLabel(PackLoader.getServerName());

		// Setting the font to bold 17 px Arial
		title.setFont(new Font("Arial", Font.BOLD, 17));

		// Setting it white
		title.setForeground(Color.WHITE);

		// Initializing the close button, an image button with quit.png as image
		// and quithover.png as image when the mouse is over it
		close = new ImageButton("quit.png", "quithover.png");

		// Setting its preferred size to 32, 32
		close.setPreferredSize(new Dimension(32, 32));

		// Adding an action listener
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Closing Minecraft
				Minecraft.getMinecraft().shutdown();

				// Exiting Java properly
				FMLCommonHandler.instance().exitJava(0, false);
			}
		});

		// Initializing the fullscreen button, an image button with
		// fullscreen.png as image and fullscreenhover.png as image when the
		// mouse is over it
		fullscreen = new ImageButton("fullscreen.png", "fullscreenhover.png");

		// Setting its preferred size to 32, 32
		fullscreen.setPreferredSize(new Dimension(32, 32));

		// Adding an action listener
		fullscreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Just calling the fullscreen method, see it in the
				// VirtualDesktop class
				FeelcraftTopBar.this.parentFrame.fullscreen();
			}
		});

		// Initializing the hide button, an image button with hide.png as image
		// and hidehover.png as image when the mouse is over it
		hide = new ImageButton("hide.png", "hidehover.png");

		// Setting its preferred size to 32, 32
		hide.setPreferredSize(new Dimension(32, 32));

		// Adding an action listener
		hide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Just setting the virtual desktop state to ICONIFIED
				FeelcraftTopBar.this.parentFrame.setState(JFrame.ICONIFIED);
			}
		});

		// Initializing a group layout
		GroupLayout layout = new GroupLayout(this);

		// Setting the current layout as it
		this.setLayout(layout);

		// This is the gap of the title
		int textCenterGap = this.parentFrame.getWidth() / 2 - title.getWidth()
				/ 2;

		// Adding the horizontal group
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addGap(textCenterGap - 35, textCenterGap - 35,
								textCenterGap - 35)
						.addComponent(title)
						.addGap(textCenterGap - 160, textCenterGap - 160,
								textCenterGap - 160)
						.addComponent(hide, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addComponent(fullscreen, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addComponent(close, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));

		// Adding the vertical group
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(title, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														hide,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														fullscreen,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														close,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE)));
	}

}
