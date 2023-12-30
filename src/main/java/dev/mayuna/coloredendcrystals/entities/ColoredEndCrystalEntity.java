package dev.mayuna.coloredendcrystals.entities;

import dev.mayuna.coloredendcrystals.ModItems;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ColoredEndCrystalEntity extends EntityEnderCrystal {

    private static final int DATA_WATCHER_ID_COLOR = 20;
    private static final String NBT_NAME_COLOR = "color";

    private static final int DATA_WATCHER_ID_SHOW_BOTTOM = 21;
    private static final String NBT_NAME_SHOW_BOTTOM = "show_bottom";


    public ColoredEndCrystalEntity(World world) {
        super(world);
    }

    /**
     * Returns the color of the end crystal
     *
     * @return The color of the end crystal
     */
    public String getColor() {
        return this.dataWatcher.getWatchableObjectString(DATA_WATCHER_ID_COLOR);
    }

    /**
     * Sets the color of the end crystal
     *
     * @param color The color of the end crystal
     */
    public void setColor(String color) {
        this.dataWatcher.updateObject(DATA_WATCHER_ID_COLOR, color);
    }

    /**
     * Returns whether the bottom of the crystal is shown
     *
     * @return Whether the bottom of the crystal is shown
     */
    public boolean getShowBottom() {
        return this.dataWatcher.getWatchableObjectByte(DATA_WATCHER_ID_SHOW_BOTTOM) == 1;
    }

    /**
     * Sets whether the bottom of the crystal is shown
     *
     * @param showBottom Whether the bottom of the crystal is shown
     */
    public void setShowBottom(boolean showBottom) {
        this.dataWatcher.updateObject(DATA_WATCHER_ID_SHOW_BOTTOM, (byte) (showBottom ? 1 : 0));
    }

    @Override
    public void onUpdate() {
        ++this.innerRotation;
        this.dataWatcher.updateObject(8, Integer.valueOf(this.health));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(DATA_WATCHER_ID_COLOR, "red");
        this.dataWatcher.addObject(DATA_WATCHER_ID_SHOW_BOTTOM, (byte) 0);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setString(NBT_NAME_COLOR, getColor());
        nbt.setBoolean(NBT_NAME_SHOW_BOTTOM, getShowBottom());
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        setColor(nbt.getString(NBT_NAME_COLOR));
        setShowBottom(nbt.getBoolean(NBT_NAME_SHOW_BOTTOM));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float p_70097_2_) {
        if (this.isEntityInvulnerable())
        {
            return false;
        }

        if (this.isDead || this.worldObj.isRemote) {
            return true;
        }

        this.health = 0;
        this.setDead();

        // Check if the damage source is a player in creative mode -> don't drop the item
        if (damageSource.getEntity() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) damageSource.getEntity();

            if (entityPlayer.capabilities.isCreativeMode) {
                return true;
            }
        }

        // Drop the item
        Item itemToDrop = ModItems.getEndCrystalItemByColor(getColor());

        if (itemToDrop != null) {
            this.entityDropItem(new ItemStack(itemToDrop, 1, 0), 0.0F);
        }

        return true;
    }

    public void onRightClick(boolean playerSneaking) {
        if (!playerSneaking) {
            setShowBottom(!getShowBottom());
            return;
        }
    }
}
