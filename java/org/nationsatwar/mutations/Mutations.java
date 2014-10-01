package org.nationsatwar.mutations;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Mutations.MODID, name=Mutations.MODID, version=Mutations.VERSION)
public class Mutations {
	public final static String MODID = "Nations At War - Mutations";
	public final static String VERSION = "0.1";

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(MutationTileEntity.class, "mutationEffect");
		MinecraftForge.EVENT_BUS.register(new MutationsHandler());
		Block.blockRegistry.addObject(83, "reeds", (new CustomBlockReed()).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("reeds").disableStats().setBlockTextureName("reeds"));
	}
	
}
