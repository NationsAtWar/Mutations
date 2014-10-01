package org.nationsatwar.mutations;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockReed;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CustomBlockReed extends BlockReed {
	
	@Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
		//super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
        
		MutationTileEntity mte = (MutationTileEntity) world.getTileEntity(x, y, z);
		if(mte.mutationEffect > 3) {
			
		}
        if (world.getBlock(x, y - 1, z) == Blocks.reeds || this.func_150170_e(world, x, y, z))
        {
            if (world.isAirBlock(x, y + 1, z))
            {
                int l;

                for (l = 1; world.getBlock(x, y - l, z) == this; ++l)
                {
                    ;
                }

                if (l < 3)
                {
                    int i1 = world.getBlockMetadata(x, y, z);
                    
                    if(mte.mutationEffect > 3) {
                    	world.setBlock(x, y, z, Block.getBlockFromName("wheat"));
                    	world.setBlockMetadataWithNotify(x,y,z, 0, 3);
                    	return;
                    }

                    if (i1 == 15)
                    {
                        world.setBlock(x, y + 1, z, this);
                        world.setBlockMetadataWithNotify(x, y, z, 0, 4);
                    }
                    else
                    {
                        world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
                    }
                }
            }
        }
    }
}
