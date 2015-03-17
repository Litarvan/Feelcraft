package fr.theshark34.feelcraft;

import java.awt.Canvas;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import net.minecraft.client.Minecraft;

public class VirtualDesktop extends JFrame {

	private JDesktopPane desktop;
	private JInternalFrame minecraft;
	private Canvas canvas;
	private FeelcraftTopBar bar;

	
	public VirtualDesktop() {
		this.setTitle(PackLoader.getServerName());
		this.setLayout(null);
		this.setIconImage(PackLoader.getIcon());
		this.setUndecorated(true);
		//this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setSize(1000, 600);
		this.setContentPane(new VDContentPane());
		this.setLocationRelativeTo(null);
		
		bar = new FeelcraftTopBar(this);
		minecraft = new JInternalFrame();
		canvas = new Canvas();
		
		minecraft.setTitle(PackLoader.getServerName());
		minecraft.setFrameIcon(new ImageIcon(PackLoader.getIcon()));
		minecraft.setSize(Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		minecraft.setLocation((int) (this.getSize().getWidth() / 2 - Minecraft.getMinecraft().displayWidth / 2), (int) (this.getSize().getHeight() / 2 - Minecraft.getMinecraft().displayHeight / 2));
		minecraft.setResizable(true);
		minecraft.setVisible(true);
				
		minecraft.add(canvas);
		
		bar.setBounds(0, 0, this.getWidth(), 30);
		
		this.getContentPane().add(minecraft);
		this.getContentPane().add(bar);
		
		this.setVisible(true);
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
}
