package chicken.creaturecorner.client.model.entity.pigeon;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import chicken.creaturecorner.client.animation.PigeonAnims;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PigeonModel<T extends Pigeon> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart pigeon;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart body;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart tail;
	private final ModelPart head_look;
	private final ModelPart head;
	private final ModelPart eyes;

	public PigeonModel(ModelPart root) {
		this.root = root.getChild("root");
		this.pigeon = this.root.getChild("pigeon");
		this.leg1 = this.pigeon.getChild("leg1");
		this.leg2 = this.pigeon.getChild("leg2");
		this.body = this.pigeon.getChild("body");
		this.wing1 = this.body.getChild("wing1");
		this.wing2 = this.body.getChild("wing2");
		this.tail = this.body.getChild("tail");
		this.head_look = this.body.getChild("head_look");
		this.head = this.head_look.getChild("head");
		this.eyes = this.head.getChild("eyes");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition pigeon = root.addOrReplaceChild("pigeon", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg1 = pigeon.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(2, 3).addBox(-0.5F, -1.15F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 15).addBox(-1.5F, 1.85F, -3.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.85F, 0.0F));

		PartDefinition leg2 = pigeon.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -1.15F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(18, 21).addBox(-1.5F, 1.85F, -3.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.85F, 0.0F));

		PartDefinition body = pigeon.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(22, 8).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -3.0F, 4.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.5F, -1.0F, -4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(22, 8).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -3.0F, 4.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.5F, -1.0F, -4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(13, 0).addBox(-3.0F, 0.0F, -1.2F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.2F, -0.5672F, 0.0F, 0.0F));

		PartDefinition head_look = body.addOrReplaceChild("head_look", CubeListBuilder.create(), PartPose.offset(0.0F, -1.6667F, -3.3333F));

		PartDefinition head = head_look.addOrReplaceChild("head", CubeListBuilder.create().texOffs(25, 28).addBox(-2.0F, -6.8333F, -2.6667F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.0F, -1.8333F, -4.6667F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, -5.8333F, -4.6667F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 1.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(41, 34).addBox(-4.0F, -3.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(2.0F, -2.8333F, -1.6667F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.head_look.xRot = headPitch * ((float) Math.PI / 180F);
		this.head_look.yRot = netHeadYaw * ((float) Math.PI / 180F);

		if (entity.isSprinting()) {
			this.animateWalk(PigeonAnims.RUN, limbSwing, limbSwingAmount*2, 1.5f, 1f);
		} else {
			this.animateWalk(PigeonAnims.WALK, limbSwing, limbSwingAmount*2, 2f, 2f);
		}

		if (!entity.onGround())
			this.animate(entity.idleAnimationState, PigeonAnims.FLY, ageInTicks, 1);
		else
			this.animate(entity.idleAnimationState, PigeonAnims.IDLE, ageInTicks, 1);
	}

	@Override
	public ModelPart root() {
		return root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, color);
	}
}