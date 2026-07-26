package com.hpup;

import com.hpup.datagen.ConceptSculkBlockLootTableProvider;
import com.hpup.datagen.ConceptSculkModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ConceptSculkDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ConceptSculkModelProvider::new);
		pack.addProvider(ConceptSculkBlockLootTableProvider::new);
	}
}
