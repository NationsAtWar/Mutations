package org.nationsatwar.mutations;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class MutationsHandler {

	@SubscribeEvent
	public void click(PlayerInteractEvent event) {
		// Modification +/-
		if (event.entityPlayer.inventory.getCurrentItem().getDisplayName().equalsIgnoreCase("Mutations Modifier")) {
			// Check if they're left clicking a block.
			if (event.action.equals(PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
				// Check if the block is a plant.
				Block b = event.world.getBlock(event.x, event.y, event.z);
				if (b.getMaterial().equals(Material.plants)) {
					MutationTileEntity mte = (MutationTileEntity) event.world.getTileEntity(event.x, event.y, event.z);
					mte.increase(event.world);
					event.entityPlayer.addChatMessage(new ChatComponentText(
							"Increasing mutation effect on" + b.getLocalizedName()));
				}
			}

			if (event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
				// Check if the block is a plant.
				Block b = event.world.getBlock(event.x, event.y, event.z);
				if (b.getMaterial().equals(Material.plants)) {
					MutationTileEntity mte = (MutationTileEntity) event.world.getTileEntity(event.x, event.y, event.z);
					mte.decrease(event.world);
					event.entityPlayer.addChatMessage(new ChatComponentText(
							"Decreasing mutation effect on" + b.getLocalizedName()));
				}
			}
		}
		
		if (event.entityPlayer.inventory.getCurrentItem().getDisplayName().equalsIgnoreCase("Mutations Reader")) {
			// Check if they're left clicking a block.
			if (event.action.equals(PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)) {
				// Check if the block is a plant.
				Block b = event.world.getBlock(event.x, event.y, event.z);
				if (b.getMaterial().equals(Material.plants)) {
					MutationTileEntity mte = (MutationTileEntity) event.world.getTileEntity(event.x, event.y, event.z);
					event.entityPlayer.addChatMessage(new ChatComponentText(
									"Mutation Effect: " + mte.mutationEffect + " on " + b.getLocalizedName()));
				}
			}
		}
	}
}
