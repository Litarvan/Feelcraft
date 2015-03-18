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

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

/**
 * The Feelcraft Server-Pack Loader - So this class loads the server-pack, a
 * server-pack is a zip file in the feelcraft mod jar named serverpack.zip. It
 * contains all the server things, the splash image, the server icon, the
 * background etc... And also a props.properties file that contains the server
 * name, etc... The server-pack is what represents the server, without it, there
 * would be a crash ! The pack loader contains a variable for each things. The
 * pack is loaded while the pre-init in the FeelcraftClassTransformer class
 * using a method named loadPack()
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class PackLoader {

	/**
	 * The server properties (the server-name, and things like this)
	 */
	private static Properties props;

	/**
	 * The server icon
	 */
	private static Image icon;

	/**
	 * The server background image
	 */
	private static Image background;

	/**
	 * The server splash image
	 */
	private static Image splash;

	/**
	 * The server name
	 */
	private static String serverName;

	/**
	 * Loads the server-pack
	 * 
	 * @throws IOException
	 *             If it failed to read a file
	 */
	static void loadPack() throws IOException {
		icon = ImageIO.read(get("icon.png"));
		background = ImageIO.read(get("background.png"));
		splash = ImageIO.read(get("splash.png"));
		props = new Properties();
		props.load(get("props.properties"));
		serverName = (String) props.get("server-name");
	}

	/**
	 * Get a file in the server-pack as an InputStream
	 * 
	 * @param file
	 *            The file to get
	 * @return The Input Stream
	 */
	private static InputStream get(String file) {
		try {
			URL entryUrl = new URL("jar:"
					+ PackLoader.class.getResource("/serverpack.zip") + "!/"
					+ file);
			return entryUrl.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * The server properties like the server-name, etc... Use this if you need
	 * to get special things in the props.properties file
	 * 
	 * @return The server properties
	 */
	public static Properties getProps() {
		return props;
	}

	/**
	 * The server icon
	 * 
	 * @return The icon
	 */
	public static Image getIcon() {
		return icon;
	}

	/**
	 * The server background image
	 * 
	 * @return The server background
	 */
	public static Image getBackground() {
		return background;
	}

	/**
	 * The server splash image
	 * 
	 * @return The splash image
	 */
	public static Image getSplash() {
		return splash;
	}

	/**
	 * The server name
	 * 
	 * @return The server name
	 */
	public static String getServerName() {
		return serverName;
	}

}
