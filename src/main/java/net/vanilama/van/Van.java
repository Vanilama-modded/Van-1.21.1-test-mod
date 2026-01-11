package net.vanilama.van;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.vanilama.van.block.ModBlocks;
import net.vanilama.van.component.ModDataComponentTypes;
import net.vanilama.van.effect.ModEffects;
import net.vanilama.van.item.ModItemGroups;
import net.vanilama.van.item.ModItems;
import net.vanilama.van.potion.ModPotions;
import net.vanilama.van.sound.ModSounds;
import net.vanilama.van.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	// ep 28

public class Van implements ModInitializer {
	public static final String MOD_ID = "van";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.registerSounds();

		ModBlocks.registerBlocks();
		ModItems.registerModItems();

		ModItemGroups.registerItemGroups();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if (player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("The Player just Hit a Sheep with an End Rod! "));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 6));
				}

				return ActionResult.PASS;
			}


			return ActionResult.SUCCESS;
		});


		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
	}
}