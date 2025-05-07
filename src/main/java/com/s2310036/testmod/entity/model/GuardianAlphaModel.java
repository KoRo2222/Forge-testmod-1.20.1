package com.s2310036.testmod.entity.model;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.s2310036.testmod.TestMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GuardianAlphaModel<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "guardian_alpha_layer"), "main");
	private final ModelPart head;
	private final ModelPart tailpart0;
	private final ModelPart tailpart1;

	public GuardianAlphaModel(ModelPart root) {
		this.head = root.getChild("head");
		this.tailpart0 = this.head.getChild("tailpart0");
		this.tailpart1 = this.tailpart0.getChild("tailpart1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -14.0F, -8.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-8.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).mirror().addBox(6.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 40).mirror().addBox(-6.0F, -16.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 40).mirror().addBox(-6.0F, -2.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 16.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition tailpart0 = head.addOrReplaceChild("tailpart0", CubeListBuilder.create().texOffs(33, -7).addBox(-2.0F, 14.0F, 8.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition tailpart1 = tailpart0.addOrReplaceChild("tailpart1", CubeListBuilder.create().texOffs(0, 54).addBox(0.0F, 14.0F, 0.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tailpart2 = tailpart1.addOrReplaceChild("tailpart2", CubeListBuilder.create().texOffs(41, 32).addBox(0.0F, 14.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tailpart2_r1 = tailpart2.addOrReplaceChild("tailpart2_r1", CubeListBuilder.create().texOffs(25, 19).addBox(1.0F, -18.5F, 3.0F, 1.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 24.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition spikepart0 = head.addOrReplaceChild("spikepart0", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart1 = head.addOrReplaceChild("spikepart1", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart2 = head.addOrReplaceChild("spikepart2", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart3 = head.addOrReplaceChild("spikepart3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart4 = head.addOrReplaceChild("spikepart4", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart5 = head.addOrReplaceChild("spikepart5", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart6 = head.addOrReplaceChild("spikepart6", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart7 = head.addOrReplaceChild("spikepart7", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart8 = head.addOrReplaceChild("spikepart8", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart9 = head.addOrReplaceChild("spikepart9", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart10 = head.addOrReplaceChild("spikepart10", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition spikepart11 = head.addOrReplaceChild("spikepart11", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart getHead() {
		return head;
	}

	public ModelPart getTailpart0() {
		return tailpart0;
	}

	public ModelPart getTailpart1() {
		return tailpart1;
	}
}