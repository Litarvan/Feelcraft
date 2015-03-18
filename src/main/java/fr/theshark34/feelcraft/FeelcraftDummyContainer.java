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

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

/**
 * The Feelcraft mod container - Contains infos of the mod like its version, its
 * name, etc... These infos will be displayed in the mods menu in the Game
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class FeelcraftDummyContainer extends DummyModContainer {

	/**
	 * The Minecraft logger
	 */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * Inits the mod metadata infos
	 */
	public FeelcraftDummyContainer() {
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "Feelcraft";
		meta.name = "Feelcraft";
		meta.version = "0.0.1-ALPHA";
		meta.credits = "TheShark34";
		meta.authorList = Arrays.asList("TheShark34");
		meta.description = "A new Minecraft experience - This mod will get your Minecraft window into a virtual desktop, with other little windows created by community plugins.";
		meta.url = "https://github.com/TheShark34/Feelcraft";
		meta.updateUrl = "https://github.com/TheShark34/Feelcraft";
		meta.screenshots = new String[0];
		meta.logoFile = "/logo.png";
	}

	/**
	 * Registers the events
	 */
	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

}
