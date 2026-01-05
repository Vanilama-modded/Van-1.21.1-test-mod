package net.vanilama.van;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.vanilama.van.block.ModBlocks;
import net.vanilama.van.component.ModDataComponentTypes;
import net.vanilama.van.item.ModItemGroups;
import net.vanilama.van.item.ModItems;
import net.vanilama.van.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Van implements ModInitializer {
	public static final String MOD_ID = "van";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());


	}
}