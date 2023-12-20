package dev.mayuna.coloredendcrystals.entities.renderers;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeableLeatherItem;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColoredEndCrystalRenderer extends EntityRenderer<ColoredEndCrystalEntity> {

    private final static Map<String, ResourceLocation> CACHED_RESOURCE_LOCATIONS = new HashMap<>();
    private final static Map<String, RenderType> CACHED_RENDER_TYPES = new HashMap<>();

    private static final float SIN_45 = (float) Math.sin(0.7853981633974483);

    private final ModelPart cube;
    private final ModelPart glass;
    private final ModelPart base;

    public ColoredEndCrystalRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
        ModelPart modelPart = context.bakeLayer(ModelLayers.END_CRYSTAL);
        this.glass = modelPart.getChild("glass");
        this.cube = modelPart.getChild("cube");
        this.base = modelPart.getChild("base");
    }

    public static float getY(ColoredEndCrystalEntity endCrystal, float f) {
        float g = (float) endCrystal.time + f;
        float h = Mth.sin(g * 0.2F) / 2.0F + 0.5F;
        h = (h * h + h) * 0.4F;
        return h - 1.4F;
    }

    public void render(ColoredEndCrystalEntity endCrystal, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        float h = getY(endCrystal, g);
        float j = ((float) endCrystal.time + g) * 3.0F;
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(getRenderType(endCrystal));
        poseStack.pushPose();
        poseStack.scale(2.0F, 2.0F, 2.0F);
        poseStack.translate(0.0F, -0.5F, 0.0F);
        int k = OverlayTexture.NO_OVERLAY;

        if (endCrystal.showsBottom()) {
            this.base.render(poseStack, vertexConsumer, i, k);
        }

        poseStack.mulPose(Axis.YP.rotationDegrees(j));
        poseStack.translate(0.0F, 1.5F + h / 2.0F, 0.0F);
        poseStack.mulPose((new Quaternionf()).setAngleAxis(1.0471976F, SIN_45, 0.0F, SIN_45));
        this.glass.render(poseStack, vertexConsumer, i, k);
        float l = 0.875F;
        poseStack.scale(0.875F, 0.875F, 0.875F);
        poseStack.mulPose((new Quaternionf()).setAngleAxis(1.0471976F, SIN_45, 0.0F, SIN_45));
        poseStack.mulPose(Axis.YP.rotationDegrees(j));
        this.glass.render(poseStack, vertexConsumer, i, k);
        poseStack.scale(0.875F, 0.875F, 0.875F);
        poseStack.mulPose((new Quaternionf()).setAngleAxis(1.0471976F, SIN_45, 0.0F, SIN_45));
        poseStack.mulPose(Axis.YP.rotationDegrees(j));

        int color = getRainbowColorBasedOnTime();
        float red = (float) ((color >> 16) & 0xFF) / 255.0F;
        float green = (float) ((color >> 8) & 0xFF) / 255.0F;
        float blue = (float) (color & 0xFF) / 255.0F;
        this.cube.render(poseStack, vertexConsumer, i, k, red, green, blue, 1.0F);

        poseStack.popPose();
        poseStack.popPose();
        BlockPos blockPos = endCrystal.getBeamTarget();
        if (blockPos != null) {
            float m = (float) blockPos.getX() + 0.5F;
            float n = (float) blockPos.getY() + 0.5F;
            float o = (float) blockPos.getZ() + 0.5F;
            float p = (float) ((double) m - endCrystal.getX());
            float q = (float) ((double) n - endCrystal.getY());
            float r = (float) ((double) o - endCrystal.getZ());
            poseStack.translate(p, q, r);
            EnderDragonRenderer.renderCrystalBeams(-p, -q + h, -r, g, endCrystal.time, poseStack, multiBufferSource, i);
        }

        super.render(endCrystal, f, g, poseStack, multiBufferSource, i);
    }

    private int getRainbowColorBasedOnTime() {
        long time = System.currentTimeMillis();
        float hue = (time % 10000) / 10000f;
        return java.awt.Color.HSBtoRGB(hue, 1f, 1f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ColoredEndCrystalEntity entity) {
        String color = entity.getColor();

        if (color == null || color.isBlank()) {
            color = "red";
        }

        var cachedResourceLocation = CACHED_RESOURCE_LOCATIONS.get(color);

        if (cachedResourceLocation != null) {
            return cachedResourceLocation;
        }

        cachedResourceLocation = new ResourceLocation(ColoredEndCrystals.MOD_ID, "textures/entity/end_crystals/" + color + "_end_crystal.png");
        CACHED_RESOURCE_LOCATIONS.put(color, cachedResourceLocation);

        return cachedResourceLocation;
    }

    public RenderType getRenderType(ColoredEndCrystalEntity endCrystal) {
        String color = endCrystal.getColor();

        if (color == null || color.isBlank()) {
            color = "red";
        }

        var cachedRenderType = CACHED_RENDER_TYPES.get(color);

        if (cachedRenderType != null) {
            return cachedRenderType;
        }

        cachedRenderType = RenderType.entityCutoutNoCull(getTextureLocation(endCrystal));
        CACHED_RENDER_TYPES.put(color, cachedRenderType);
        return cachedRenderType;
    }

    public boolean shouldRender(ColoredEndCrystalEntity endCrystal, Frustum frustum, double d, double e, double f) {
        return super.shouldRender(endCrystal, frustum, d, e, f) || endCrystal.getBeamTarget() != null;
    }
}
