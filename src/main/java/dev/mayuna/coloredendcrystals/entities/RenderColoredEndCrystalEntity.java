package dev.mayuna.coloredendcrystals.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dev.mayuna.coloredendcrystals.Coloredendcrystals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderColoredEndCrystalEntity extends RenderEnderCrystal {

    private final static Map<String, ResourceLocation> CACHED_RESOURCE_LOCATIONS = new HashMap<>();

    private static final ModelBase modelWithBottom = new ModelEnderCrystal(0.0F, true);
    private static final ModelBase modelWithoutBottom = new ModelEnderCrystal(0.0F, false);

    public RenderColoredEndCrystalEntity() {
        super();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return getEntityTexture((ColoredEndCrystalEntity) entity);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEnderCrystal entity) {
        return getEntityTexture((ColoredEndCrystalEntity) entity);
    }

    protected ResourceLocation getEntityTexture(ColoredEndCrystalEntity entity) {
        String color = entity.getColor();

        if (color == null || color.isEmpty()) {
            color = "red";
        }

        if (CACHED_RESOURCE_LOCATIONS.containsKey(color)) {
            return CACHED_RESOURCE_LOCATIONS.get(color);
        }

        ResourceLocation resourceLocation = new ResourceLocation(Coloredendcrystals.MODID, "textures/entity/end_crystals/" + color + "_end_crystal.png");
        CACHED_RESOURCE_LOCATIONS.put(color, resourceLocation);
        return resourceLocation;
    }

    @Override
    public void doRender(EntityEnderCrystal entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        doRender((ColoredEndCrystalEntity) entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void doRender(ColoredEndCrystalEntity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        float f2 = (float) entity.innerRotation + p_76986_9_;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) p_76986_2_, (float) p_76986_4_, (float) p_76986_6_);
        this.bindTexture(getEntityTexture(entity));
        float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
        f3 += f3 * f3;

        if (entity.getShowBottom()) {
            modelWithBottom.render(entity, 0.0F, f2 * 3.0F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
        } else {
            modelWithoutBottom.render(entity, 0.0F, f2 * 3.0F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
        }

        GL11.glPopMatrix();
    }
}
