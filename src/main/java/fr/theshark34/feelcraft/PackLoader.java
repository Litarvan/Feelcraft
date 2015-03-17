package fr.theshark34.feelcraft;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.zip.ZipException;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;

public class PackLoader {

	public static final File SERVER_PACK = new File(
			Minecraft.getMinecraft().mcDataDir, "serverpack.zip");

	private static Properties props;
	private static Image icon;
	private static Image background;
	private static String serverName;
	
	public static void loadPack() throws ZipException, IOException {
		System.out.println(SERVER_PACK.getAbsolutePath());
		icon = ImageIO.read(get("icon.png"));
		background = ImageIO.read(get("background.png"));
		props = new Properties();
		props.load(get("props.properties"));
		serverName = (String) props.get("server-name");
	}

	private static InputStream get(String file) {
		try {
			URL entryUrl = new URL("jar:" + SERVER_PACK.toURI().toURL()
					+ "!/" + file);
			return entryUrl.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Properties getProps() {
		return props;
	}

	public static Image getIcon() {
		return icon;
	}

	public static Image getBackground() {
		return background;
	}

	public static String getServerName() {
		return serverName;
	}

}
