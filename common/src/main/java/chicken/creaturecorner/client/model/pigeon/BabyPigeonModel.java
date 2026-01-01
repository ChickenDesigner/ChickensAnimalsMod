package chicken.creaturecorner.client.model.pigeon;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import chicken.creaturecorner.client.animation.PigeonAnims;
import chicken.creaturecorner.server.entity.obj.PigeonEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BabyPigeonModel<T extends PigeonEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart pigeon;
	private final ModelPart legs_adjust;
	private final ModelPart leg2;
	private final ModelPart leg1;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart head_look;
	private final ModelPart head;

	public BabyPigeonModel(ModelPart root) {
		this.root = root.getChild("root");
		this.pigeon = this.root.getChild("pigeon");
		this.legs_adjust = this.pigeon.getChild("legs_adjust");
		this.leg2 = this.legs_adjust.getChild("leg2");
		this.leg1 = this.legs_adjust.getChild("leg1");
		this.body = this.pigeon.getChild("body");
		this.tail = this.body.getChild("tail");
		this.wing1 = this.body.getChild("wing1");
		this.wing2 = this.body.getChild("wing2");
		this.head_look = this.body.getChild("head_look");
		this.head = this.head_look.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition pigeon = root.addOrReplaceChild("pigeon", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs_adjust = pigeon.addOrReplaceChild("legs_adjust", CubeListBuilder.create(), PartPose.offset(-1.5F, -1.0F, 1.0F));

		PartDefinition leg2 = legs_adjust.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.01F))
		.texOffs(0, 16).addBox(-1.5F, 1.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition leg1 = legs_adjust.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.01F))
		.texOffs(0, 16).addBox(-1.5F, 1.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = pigeon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(19, 15).addBox(-2.0F, -4.0F, 2.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(14, 5).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 21).addBox(-0.4F, -1.5F, -0.5F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(-2.5F, -2.5F, -2.5F));

		PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(14, 5).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 21).addBox(0.4F, -1.5F, -0.5F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(2.5F, -2.5F, -2.5F));

		PartDefinition head_look = body.addOrReplaceChild("head_look", CubeListBuilder.create(), PartPose.offset(0.5F, -3.0F, -2.0F));

		PartDefinition head = head_look.addOrReplaceChild("head", CubeListBuilder.create().texOffs(10, 10).addBox(-1.0F, -3.0F, -3.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.0F, -1.0F, -2.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(11, 13).addBox(-2.0F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(-2, 19).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.5F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.head_look.xRot = headPitch * ((float) Math.PI / 180F);
		this.head_look.yRot = netHeadYaw * ((float) Math.PI / 180F);

		if (entity.isSprinting()) {
			this.animateWalk(PigeonAnims.BABY_RUN, limbSwing, limbSwingAmount, 2.5f, 1f);
		} else {
			this.animateWalk(PigeonAnims.BABY_WALK, limbSwing, limbSwingAmount, 2.5f, 2f);
		}

		this.animate(entity.idleAnimationState, PigeonAnims.IDLE, ageInTicks, 1);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		poseStack.pushPose();

		poseStack.translate(0, -1, 0);

		root.render(poseStack, buffer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}

	@Override
	public ModelPart root() {
		return pigeon;
	}
}