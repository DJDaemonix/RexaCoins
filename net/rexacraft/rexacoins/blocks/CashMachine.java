package net.rexacraft.rexacoins.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.rexacraft.rexacoins.RexaCoins;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CashMachine extends Block
{
    private IIcon top, bottom, side, front, back;

    public void registerBlockIcons(IIconRegister iiconRegister)
    {
        this.blockIcon = iiconRegister.registerIcon(RexaCoins.MODID + ":CashMachine_side");
        this.top = iiconRegister.registerIcon(RexaCoins.MODID + ":CashMachine_top");
        this.bottom = iiconRegister.registerIcon(RexaCoins.MODID + ":CashMachine_top");
        this.front = iiconRegister.registerIcon(RexaCoins.MODID + ":CashMachine_front");
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        if((side == 3 && metadata == 0) || (side == 4 && metadata == 1) || (side == 2 && metadata == 2) || (side == 5 && metadata == 3))
        {
            return this.front;
        }
        return this.blockIcon;
    }

    public CashMachine()
    {
        super(Material.iron);
    }
}