package fr.theshark34.feelcraft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FeelcraftTopBar extends JPanel {

	private AntialiasLabel title;
	private ImageButton close;
	private ImageButton fullscreen;
	private ImageButton hide;

	private JFrame parentFrame;

	public FeelcraftTopBar(JFrame parentFrame) {
		this.parentFrame = parentFrame;

		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());

		title = new AntialiasLabel(PackLoader.getServerName());
		title.setForeground(Color.WHITE);

		close = new ImageButton("quit.png", "quithover.png");
		close.setPreferredSize(new Dimension(32, 32));
		fullscreen = new ImageButton("fullscreen.png", "fullscreenhover.png");
		fullscreen.setPreferredSize(new Dimension(32, 32));
		hide = new ImageButton("hide.png", "hidehover.png");
		hide.setPreferredSize(new Dimension(32, 32));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);

		int textCenterGap = this.parentFrame.getWidth() / 2 - title.getWidth()
				/ 2;

		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addGap(textCenterGap - 15, textCenterGap - 15, textCenterGap - 15)
						.addComponent(title)
						.addGap(textCenterGap - 150, textCenterGap - 150, textCenterGap - 150)
						.addComponent(hide,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addComponent(fullscreen,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addComponent(close,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(hide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(fullscreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(0, 0, Short.MAX_VALUE))
	        );
	}

}
