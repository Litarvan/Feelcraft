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

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

/**
 * The Feelcraft FML loading plugin - Its the class that is identified by FML as
 * a loading plugin, so it will be loaded by FML and will transfrom class, loads
 * Feelcraft, etc... It also refers to the mod container that contains the mod
 * infos such as the version, the name, the author, etc...
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
@MCVersion("1.7.10")
public class FeelcraftFMLLoadingPlugin implements IFMLLoadingPlugin {

	/**
	 * This returns the class-transformer class, actually this is
	 * FeelcraftClassTransformer
	 */
	@Override
	public String[] getASMTransformerClass() {
		return new String[] { FeelcraftClassTransformer.class.getName() };
	}

	/**
	 * This returns the access-transformer class, but we haven't any of this
	 */
	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	/**
	 * This returns the mod container that contains the mod infos such as the
	 * version, the name, the author, etc...
	 */
	@Override
	public String getModContainerClass() {
		return FeelcraftDummyContainer.class.getName();
	}

	/**
	 * This returns the setup class, I don't really know what's it, but we
	 * haven't any of it
	 */
	@Override
	public String getSetupClass() {
		return null;
	}

	/**
	 * This is called by FML to inject data into things. I don't really know
	 * what are these things so lets keeping this empty
	 */
	@Override
	public void injectData(Map<String, Object> arg0) {
	}

}
