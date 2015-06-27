package net.rexacraft.rexacoins.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.rexacraft.rexacoins.RexaCoins;

public class BlockCashMachine extends Block
{
    private IIcon top, front;

    public BlockCashMachine()
    {
        super(Material.iron);
    }

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(RexaCoins.MODID + ":cash_machine_side");
        this.top = register.registerIcon(RexaCoins.MODID + ":cash_machine_top");
        this.front = register.registerIcon(RexaCoins.MODID + ":cash_machine_front");
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double(living.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if((side == 3 && metadata == 0) || (side == 4 && metadata == 1) || (side == 2 && metadata == 2) || (side == 5 && metadata == 3))
        {
            return this.front;
        }

        if(side == 0 || side == 1)
        {
            return this.top;
        }

        return this.blockIcon;
    }
}