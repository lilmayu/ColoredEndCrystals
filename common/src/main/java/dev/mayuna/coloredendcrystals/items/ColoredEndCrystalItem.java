package dev.mayuna.coloredendcrystals.items;

import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.EndCrystalItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredEndCrystalItem extends EndCrystalItem {

    private final String color;

    public ColoredEndCrystalItem(String color) {
        super(new Properties().rarity(Rarity.RARE).arch$tab(ModCreativeTabs.MAIN_TAB));
        this.color = color;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.coloredendcrystals.colored_end_crystal.tooltip.right_click"));
        list.add(Component.translatable("item.coloredendcrystals.colored_end_crystal.tooltip.break"));
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();

        BlockPos blockPos = useOnContext.getClickedPos().above();

        if (!level.isEmptyBlock(blockPos)) {
            return InteractionResult.FAIL;
        }

        double d = blockPos.getX();
        double e = blockPos.getY();
        double f = blockPos.getZ();
        List<Entity> list = level.getEntities(null, new AABB(d, e, f, d + 1.0, e + 2.0, f + 1.0));

        if (!list.isEmpty()) {
            return InteractionResult.FAIL;
        }

        if (level instanceof ServerLevel) {
            var entity = ModEntityTypes.COLORED_END_CRYSTAL.get().create(level);

            if (entity != null) {
                entity.setColor(this.color);
                entity.setShowBottom(false);
                entity.setPos(d + 0.5, e, f + 0.5);

                level.addFreshEntity(entity);
            }

            level.gameEvent(useOnContext.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);

            EndDragonFight endDragonFight = ((ServerLevel)level).getDragonFight();
            if (endDragonFight != null) {
                endDragonFight.tryRespawn();
            }
        }

        useOnContext.getItemInHand().shrink(1);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        // Prevent enchantment glint to see the colors better
        return false;
    }
}
