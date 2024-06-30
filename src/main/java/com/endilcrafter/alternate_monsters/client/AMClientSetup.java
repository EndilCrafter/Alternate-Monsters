package com.endilcrafter.alternate_monsters.client;

import com.endilcrafter.alternate_monsters.AlternateMonsters;
import com.endilcrafter.alternate_monsters.client.models.CryingModel;
import com.endilcrafter.alternate_monsters.client.renderer.entity.CryingRenderer;
import com.endilcrafter.alternate_monsters.common.register.AMEntityTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class AMClientSetup {
    public static ModelLayerLocation CRYING = new ModelLayerLocation(
            ResourceLocation.parse(AlternateMonsters.MODID), "crying");

    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AMClientSetup.CRYING, CryingModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AMEntityTypes.CRYING.get(), CryingRenderer::new);
        event.registerEntityRenderer(AMEntityTypes.SMALL_CRYING_BALL.get(), renderer -> new ThrownItemRenderer<>(renderer, 0.75F, true));
    }
}
