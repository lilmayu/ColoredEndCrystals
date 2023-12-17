package dev.mayuna.coloredendcrystals.entities;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
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

    private static final EntityDataAccessor<String> DATA_COLOR = SynchedEntityData.defineId(ColoredEndCrystalEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> DATA_SHIFTED_UP = SynchedEntityData.defineId(ColoredEndCrystalEntity.class, EntityDataSerializers.BOOLEAN);

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
     * Determines if the crystal was shifted up
     *
     * @return If the crystal was shifted up
     */
    public boolean isShiftedUp() {
        return this.getEntityData().get(DATA_SHIFTED_UP);
    }

    /**
     * Sets if the crystal was shifted up
     *
     * @param shiftedUp If the crystal was shifted up
     */
    public void setShiftedUp(boolean shiftedUp) {
        this.getEntityData().set(DATA_SHIFTED_UP, shiftedUp);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_COLOR, "red");
        this.getEntityData().define(DATA_SHIFTED_UP, false);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("color", this.getColor());
        compoundTag.putBoolean("shifted_up", this.showsBottom());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setColor(compoundTag.getString("color"));
        this.setShiftedUp(compoundTag.getBoolean("shifted_up"));
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
            var item = ColoredEndCrystals.Items.getEndCrystalItemByColor(this.getEntityData().get(DATA_COLOR));

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

    public void onRightClick(boolean shiftKeyDown) {
        if (shiftKeyDown) {
            double newY = this.getY();

            if (this.isShiftedUp()) {
                newY -= 1;
            } else {
                newY += 1;
            }

            this.setShiftedUp(!this.isShiftedUp());
            this.moveTo(this.getX(), newY, this.getZ());

            return;
        }

        this.setShowBottom(!this.showsBottom());
    }
}
