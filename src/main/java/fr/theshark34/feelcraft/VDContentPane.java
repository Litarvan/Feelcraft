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

import javax.swing.JDesktopPane;

/**
 * The Virtual Desktop content pane, just a JDesktopPane with the server-pack
 * background drawed in background
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class VDContentPane extends JDesktopPane {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(PackLoader.getBackground(), 0, 0, this.getWidth(),
				this.getHeight(), this);
	}

}
