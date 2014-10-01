package org.nationsatwar.mutations;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MutationTileEntity extends TileEntity {
	int mutationEffect = 0;
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("mutationEffect", this.mutationEffect);
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.mutationEffect = nbt.getInteger("mutationEffect");
	}

	public void increase(World world) {
		this.mutationEffect++;
		world.notifyBlockChange(xCoord, yCoord, zCoord, this.blockType);
	}
	
	public void decrease(World world) {
		this.mutationEffect--;
		world.notifyBlockChange(xCoord, yCoord, zCoord, this.blockType);
	}
}
