package com.endilcrafter.alternate_monsters.client.renderer.entity;

import com.endilcrafter.alternate_monsters.AlternateMonsters;
import com.endilcrafter.alternate_monsters.client.AMClientSetup;
import com.endilcrafter.alternate_monsters.client.models.CryingModel;
import com.endilcrafter.alternate_monsters.common.entity.Crying;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CryingRenderer extends MobRenderer<Crying, CryingModel<Crying>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(AlternateMonsters.MODID, "textures/entity/crying.png");

    public CryingRenderer(EntityRendererProvider.Context p_173933_) {
        super(p_173933_, new CryingModel<>(p_173933_.bakeLayer(AMClientSetup.CRYING)), 0.5F);
    }

    protected int getBlockLightLevel(Crying pEntity, BlockPos pPos) {
        return 5;
    }

    public ResourceLocation getTextureLocation(Crying pEntity) {
        return TEXTURE;
    }
}
