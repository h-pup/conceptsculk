package com.hpup;

import com.hpup.block.ConceptSculkBlocks;
import com.hpup.worldgen.ConceptSculkProcessors;
import com.hpup.worldgen.ConceptSculkWorldGen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConceptSculk implements ModInitializer {
	public static final String MOD_ID = "conceptsculk";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " Loading");

		ConceptSculkBlocks.registerModBlocks();
		ConceptSculkProcessors.register();
		ConceptSculkWorldGen.register();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
