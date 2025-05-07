package com.s2310036.testmod.event;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.entity.TestEntities;
import com.s2310036.testmod.entity.model.GuardianAlphaModel;
import com.s2310036.testmod.entity.renderer.GuardianAlphaRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TestEventBusClientEvent {
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GuardianAlphaModel.LAYER_LOCATION,
                GuardianAlphaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TestEntities.GUARDIAN_ALPHA.get(),
                GuardianAlphaRenderer::new);
    }
}
