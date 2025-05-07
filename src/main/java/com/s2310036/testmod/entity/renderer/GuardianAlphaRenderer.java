package com.s2310036.testmod.entity.renderer;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.entity.custom.GuardianAlpha;
import com.s2310036.testmod.entity.model.GuardianAlphaModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GuardianAlphaRenderer extends MobRenderer<GuardianAlpha, GuardianAlphaModel<GuardianAlpha>> {
    private static final ResourceLocation GUARDIAN_ALPHA_LOCATION =
            ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
                    "textures/entity/guardian_alpha.png");

    public GuardianAlphaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,
                new GuardianAlphaModel<>(pContext.bakeLayer(GuardianAlphaModel.LAYER_LOCATION)),
                0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GuardianAlpha pEntity) {
        return GUARDIAN_ALPHA_LOCATION;
    }
}
