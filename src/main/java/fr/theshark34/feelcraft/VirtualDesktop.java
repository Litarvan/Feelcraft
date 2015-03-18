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

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;

/**
 * The Feelcraft Virtual Desktop - This is the most important class, this is the
 * virtual desktop that contains all the feelcraft frames of the plugins, and
 * Minecraft. It has a FeelcraftTopBar on top of it, and a VDContentPane as
 * JDesktopPane.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class VirtualDesktop extends JFrame {

	/**
	 * The Minecraft internal frame
	 */
	private JInternalFrame minecraft;

	/**
	 * The LWJGL Canvas in the Minecraft internal frame
	 */
	private Canvas canvas;

	/**
	 * The top bar
	 */
	private FeelcraftTopBar bar;

	/**
	 * If the frame is in fullscreen
	 */
	private boolean isFullscreen = true;

	/**
	 * The saved size when switching to fullscreen
	 */
	private Dimension savedSize;

	/**
	 * Creates the virtual desktop
	 */
	public VirtualDesktop() {
		// Setting the title
		this.setTitle(PackLoader.getServerName());

		// Using null layout
		this.setLayout(null);

		// Setting the icon
		this.setIconImage(PackLoader.getIcon());

		// Setting it undecorated
		this.setUndecorated(true);

		// Setting it fullscreen
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		// Setting an instance of a VDContentPane as the content pane
		this.setContentPane(new VDContentPane());

		// Setting his location relative to nothing
		this.setLocationRelativeTo(null);

		// Initializing the bar, the Minecraft internal frame, and the Minecraft
		// LWJGL canvas
		bar = new FeelcraftTopBar(this);
		minecraft = new JInternalFrame();
		canvas = new Canvas();

		// Initializing the Minecraft internal frame
		minecraft.setTitle(PackLoader.getServerName());
		minecraft.setFrameIcon(new ImageIcon(PackLoader.getIcon()));
		minecraft.setSize(Minecraft.getMinecraft().displayWidth + 10,
				Minecraft.getMinecraft().displayHeight + 10);
		minecraft.setLocation(
				(int) (this.getWidth() / 2 - minecraft.getWidth() / 2),
				(int) (this.getHeight() / 2 - minecraft.getHeight() / 2) + 10);
		minecraft.setResizable(true);
		minecraft.setVisible(true);

		// Adding it the Minecraft LWJGL Canvas
		minecraft.add(canvas);

		// Setting the bar size
		bar.setBounds(0, 0, this.getWidth(), 30);

		// Adding Minecraft and the top bar
		this.getContentPane().add(minecraft);
		this.getContentPane().add(bar);

		// Adding a window listener
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				// Closing Minecraft
				Minecraft.getMinecraft().shutdown();

				// Exiting Java properly
				FMLCommonHandler.instance().exitJava(0, false);
			}
		});

		// Setting it visible
		this.setVisible(true);
	}

	/**
	 * The Minecraft LWJGL Canvas in the Minecraft internal frame
	 * 
	 * @return The LWJGL Canvas
	 */
	public Canvas getCanvas() {
		return this.canvas;
	}

	/**
	 * Resizes the components using the new virtual desktop size
	 */
	public void resize() {
		// Centering the Minecraft internal frame
		minecraft.setLocation(
				(int) (this.getWidth() / 2 - minecraft.getWidth() / 2),
				(int) (this.getHeight() / 2 - minecraft.getHeight() / 2) + 10);

		// Getting the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// Centering the virtual desktop
		this.setLocation(
				(int) (screenSize.getWidth() / 2 - this.getWidth() / 2),
				(int) (screenSize.getHeight() / 2 - this.getHeight() / 2));

		// Recreating the top bar
		this.remove(bar);
		bar = new FeelcraftTopBar(this);
		bar.setBounds(0, 0, this.getWidth(), 30);
		this.getContentPane().add(bar);
	}

	/**
	 * Sets the virtual desktop fullscreen or not
	 */
	public void fullscreen() {
		// If it is in fullscreen
		if (isFullscreen) {
			// Setting the size to the saved size if it isn't null, if it is
			// setting the size to 1000x600
			this.setSize(savedSize != null ? savedSize : new Dimension(1000,
					600));

			// Resizing the components using the new virtual desktop size
			this.resize();

			// Setting fullscreen to false
			isFullscreen = false;
		} else {
			// Saving the size
			this.savedSize = this.getSize();

			// Setting the virtual desktop fullscreen
			this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

			// Resizing the components using the new virtual desktop size
			this.resize();

			// Setting fullscreen to true
			isFullscreen = true;
		}
	}

}
