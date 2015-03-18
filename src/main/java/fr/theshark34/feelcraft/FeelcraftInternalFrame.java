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

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 * The Feelcraft Internal Frame - So this is an internal frame for the virtual
 * desktop. It extends JInternalFrame, but it is settings things to it and adds
 * border, etc... To add object to it, use getContainerPanel().add(). Normally,
 * plugins are using this class to creates internal frames. It needs to always
 * call the first normal constructor, because it sets all the importants things.
 * Else it would be a normal JInternalFrame.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class FeelcraftInternalFrame extends JInternalFrame {

	/**
	 * The frame container (like the frame, without the border)
	 */
	private JPanel container;

	/**
	 * Inits the internal frame ! ALWAYS CALL SUPER() WHEN OVERRIDING IT !
	 */
	public FeelcraftInternalFrame() {
		putClientProperty("JInternalFrame.isPalette", true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}

	/**
	 * Returns the container panel, always call getContainerPanel().add() to add
	 * things to the frame
	 * 
	 * @return The container panel
	 */
	public JPanel getContainerPanel() {
		return container;
	}
}
