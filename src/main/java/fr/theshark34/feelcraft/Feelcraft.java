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

import java.io.IOException;
import java.util.zip.ZipException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

/**
 * The Feelcraft main class - Has a start method called by the modified
 * Minecraft class at the starting of the game. It will load the server pack
 * with the {@link PackLoader}, a zip file that contains backgrounds, infos,
 * etc... It will start the virtual desktop, and also get Minecraft into an
 * internal frame. Finally it will loads the plugins.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class Feelcraft {

	/**
	 * The Minecraft logger
	 */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * The current Feelcraft version
	 */
	public static final String VERSION = "0.0.1-ALPHA";

	/**
	 * The instance of the {@link VirtualDesktop}
	 */
	private static VirtualDesktop vd;

	/**
	 * Starts Feelcraft, called by the startGame method of the modified
	 * Minecraft class. t will load the server pack with the {@link PackLoader},
	 * a zip file that contains backgrounds, infos, etc... It will start the
	 * virtual desktop, and also get Minecraft into an internal frame. Finally
	 * it will loads the plugins.
	 */
	public static void start() {
		// Printing some messages
		logger.info("[Feelcraft] Starting Feelcraft " + VERSION);
		logger.info("[Feelcraft] Loading the serverpack");

		// Loading the server pack
		try {
			PackLoader.loadPack();
		} catch (ZipException e) {
		} catch (IOException e) {
		}

		// Loading the Nimbus Look N Feel
		logger.info("[Feelcraft] Setting the Nimbus Look N Feel");
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
		} catch (ClassNotFoundException e1) {
		} catch (InstantiationException e1) {
		} catch (IllegalAccessException e1) {
		} catch (UnsupportedLookAndFeelException e1) {
		}

		// Creating the virtual desktop
		logger.info("[Feelcraft] Creating the virtual desktop");
		vd = new VirtualDesktop();

		// Adding it Minecraft
		logger.info("[Feelcraft] Adding minecraft");
		try {
			Display.setParent(vd.getCanvas());
			logger.info("[Feelcraft] Nice !");
		} catch (LWJGLException e) {
			// If it failed, printing the error, hiding the virtual desktop, and
			// aborting
			logger.error("[Feelcraft] Unable to add Minecraft ! Aborting !");
			e.printStackTrace();
			vd.setVisible(false);
			return;
		}

		// Loading the plugins
		logger.info("[Feelcraft] Adding plugins");

		// End =)
		logger.info("[Feelcraft] Yeah ! Feelcraft loaded successfully without any known problem !");
	}

}
