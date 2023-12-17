package dev.mayuna.coloredendcrystals.entities;

import dev.mayuna.coloredendcrystals.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.end.EndDragonFight;

public class ColoredEndCrystalEntity extends EndCrystal {

    public static final byte SHIFTED_BY_MIN = 0;
    public static final byte SHIFTED_BY_MAX = 2;

    private static final EntityDataAccessor<String> DATA_COLOR = SynchedEntityData.defineId(ColoredEndCrystalEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Byte> DATA_SHIFTED_BY = SynchedEntityData.defineId(ColoredEndCrystalEntity.class, EntityDataSerializers.BYTE);

    public ColoredEndCrystalEntity(EntityType<ColoredEndCrystalEntity> entityType, Level level, String color) {
        super(entityType, level);
        this.setColor(color);
    }

    /**
     * Gets the color of the end crystal
     *
     * @return The color of the end crystal
     */
    public String getColor() {
        return this.getEntityData().get(DATA_COLOR);
    }

    /**
     * Sets the color of the end crystal
     *
     * @param color The color of the end crystal
     */
    public void setColor(String color) {
        this.getEntityData().set(DATA_COLOR, color);
    }

    /**
     * Gets the amount the crystal was shifted up
     *
     * @return The amount the crystal was shifted up
     */
    public byte getShiftedBy() {
        return this.getEntityData().get(DATA_SHIFTED_BY);
    }

    /**
     * Sets the amount the crystal was shifted up
     *
     * @param shiftedUpAmount The amount the crystal was shifted up
     */
    public void setShiftedBy(byte shiftedUpAmount) {
        this.getEntityData().set(DATA_SHIFTED_BY, shiftedUpAmount);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_COLOR, "red");
        this.getEntityData().define(DATA_SHIFTED_BY, (byte) 0);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("color", this.getColor());
        compoundTag.putByte("shifted_by", this.getShiftedBy());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setColor(compoundTag.getString("color"));
        this.setShiftedBy(compoundTag.getByte("shifted_by"));
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        }

        if (damageSource.getEntity() instanceof EnderDragon) {
            return false;
        }

        if (this.isRemoved() || this.level().isClientSide) {
            return false;
        }

        this.remove(RemovalReason.KILLED);

        if (!damageSource.isCreativePlayer()) {
            var item = ModItems.getEndCrystalItemByColor(this.getEntityData().get(DATA_COLOR));

            if (item != null) {
                // Drop the end crystal item
                this.spawnAtLocation(new ItemStack(item));
            }
        }

        this.onDestroyedBy(damageSource);
        return true;
    }

    private void onDestroyedBy(DamageSource damageSource) {
        if (this.level() instanceof ServerLevel) {
            EndDragonFight endDragonFight = ((ServerLevel) this.level()).getDragonFight();
            if (endDragonFight != null) {
                endDragonFight.onCrystalDestroyed(this, damageSource);
            }
        }
    }

    /**
     * Returns the next amount the crystal should be shifted by.
     *
     * @return The next amount the crystal should be shifted by.
     */
    private byte getNextShiftedBy() {
        byte currentShiftedBy = this.getShiftedBy();

        if (currentShiftedBy == SHIFTED_BY_MAX) {
            return SHIFTED_BY_MIN;
        }

        return (byte) (currentShiftedBy + 1);
    }

    /**
     * Called when the end crystal is right clicked.
     *
     * @param shiftKeyDown If the shift key was down when the end crystal was right clicked.
     */
    public void onRightClick(boolean shiftKeyDown) {
        if (!shiftKeyDown) {
            this.setShowBottom(!this.showsBottom());
            return;
        }

        byte nextShiftedBy = this.getNextShiftedBy();

        double currentY = this.getY();
        double baseY = currentY - this.getShiftedBy() * 0.51;
        double newY = baseY + nextShiftedBy * 0.51;

        this.setShiftedBy(nextShiftedBy);
        this.moveTo(this.getX(), newY, this.getZ());
    }
}
