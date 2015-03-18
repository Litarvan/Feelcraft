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

import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * The Class Transformer - Inject a line that call the {@link Feelcraft} start
 * method in the startGame method in the Minecraft class.
 * 
 * @author TheShark34
 * @version 0.0.1-ALPHA
 */
public class FeelcraftClassTransformer implements IClassTransformer {

	/**
	 * The Minecraft logger
	 */
	private static final Logger logger = LogManager.getLogger();

	/**
	 * Inject bytecode into the Minecraft class
	 * 
	 * @param name
	 *            The class name
	 * @param transformedName
	 *            I don't really know what is this
	 * @param basicClass
	 *            The class bytes
	 */
	@Override
	public byte[] transform(String name, String transformedName,
			byte[] basicClass) {

		// If the class name is bao (the Minecraft class obfuscated name)
		if (name.equals("bao"))
			// Patching the obfuscated game
			return patchClassASM(name, basicClass, true);

		// Else if the class name is net.minecraft.client.Minecraft
		else if (name.equals("net.minecraft.client.Minecraft"))
			// Patching the deobfuscated game
			return patchClassASM(name, basicClass, false);

		// Else return the given class
		return basicClass;
	}

	/**
	 * Patchs the Minecraft class
	 * 
	 * @param name
	 *            The class name
	 * @param bytes
	 *            The initial class bytes
	 * @param obfuscated
	 *            If the class is obfuscated
	 * @return The modified bytes
	 */
	public byte[] patchClassASM(String name, byte[] bytes, boolean obfuscated) {
		// Starting the pre init
		Feelcraft.preInit();
		
		// Printing messages
		logger.info("[Feelcraft] Starting patching Minecraft");
		logger.info("[Feelcraft] Target class : " + name);

		// Getting the target method if the game is obfuscated or not
		String targetMethod;
		if (obfuscated)
			targetMethod = "ag";
		else
			targetMethod = "startGame";

		// Getting the class nod and reading the initial class
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);

		// Just a boolean that will be true if the patch will be done to check
		// if it was done
		boolean patchDone = false;

		// Getting the class methods
		Iterator<MethodNode> methods = classNode.methods.iterator();

		// For each method in the class
		while (methods.hasNext()) {
			// Getting the method
			MethodNode m = methods.next();

			// If the method is our target method
			if ((m.name.equals(targetMethod) && m.desc.equals("()V"))) {
				// Printing a message
				logger.info("[Feelcraft] Patching method : " + m.name + m.desc);

				// Insert a line that will call Feelcraft.start at the top of
				// the method
				m.instructions.insertBefore(m.instructions.getFirst(),
						new MethodInsnNode(Opcodes.INVOKESTATIC,
								"fr/theshark34/feelcraft/Feelcraft", "start",
								"()V", false));

				// Setting patchDone to true
				patchDone = true;

				// Stopping the loop
				break;
			}
		}

		// If the patch wasn't done
		if (!patchDone)
			// Printing a warning message
			logger.warn("[Feelcraft] Warning the patch wasn't done ! Some things will not going to work !");

		// Writing the patched class
		logger.info("[Feelcraft] Writing the patched class");
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS
				| ClassWriter.COMPUTE_FRAMES);
		classNode.accept(writer);

		// Printing a done message
		if (patchDone)
			logger.info("[Feelcraft] Successfully patched Minecraft !");
		else
			logger.info("[Feelcraft] Done");

		// Returning the modified bytes
		return writer.toByteArray();
	}

}
