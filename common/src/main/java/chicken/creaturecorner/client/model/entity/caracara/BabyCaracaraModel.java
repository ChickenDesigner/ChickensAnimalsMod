package chicken.creaturecorner.client.model.entity.caracara;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import chicken.creaturecorner.client.animation.BabyCaracaraAnims;
import chicken.creaturecorner.server.entity.obj.Caracara;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BabyCaracaraModel<T extends Caracara> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart caracara;
	private final ModelPart top;
	private final ModelPart body;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart tail;
	private final ModelPart look;
	private final ModelPart head;
	private final ModelPart hair;
	private final ModelPart leg1;
	private final ModelPart leg2;

	public BabyCaracaraModel(ModelPart root) {
		this.root = root.getChild("root");
		this.caracara = this.root.getChild("caracara");
		this.top = this.caracara.getChild("top");
		this.body = this.top.getChild("body");
		this.wing1 = this.body.getChild("wing1");
		this.wing2 = this.body.getChild("wing2");
		this.tail = this.body.getChild("tail");
		this.look = this.top.getChild("look");
		this.head = this.look.getChild("head");
		this.hair = this.head.getChild("hair");
		this.leg1 = this.caracara.getChild("leg1");
		this.leg2 = this.caracara.getChild("leg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition caracara = root.addOrReplaceChild("caracara", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top = caracara.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition body = top.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -2.5F, -4.5F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -2.5F, -0.5F));

		PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(19, 7).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(15, 16).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -1.0F, -3.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(15, 4).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(3.0F, -2.5F, 2.5F));

		PartDefinition look = top.addOrReplaceChild("look", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -4.0F));

		PartDefinition head = look.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(15, 24).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition leg1 = caracara.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(-1, 12).addBox(-1.5F, 2.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 1.0F));

		PartDefinition leg2 = caracara.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(17, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 12).addBox(-1.5F, 2.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(entity.idleAnimationState, BabyCaracaraAnims.IDLE, ageInTicks, 1);

		if (entity.isAggressive())
			this.animateWalk(BabyCaracaraAnims.RUN, limbSwing, limbSwingAmount*2, 2f, 2f);
		else
			this.animateWalk(BabyCaracaraAnims.WALK, limbSwing, limbSwingAmount*2, 2f, 2f);

		float prevHeadX = this.head.xRot;
		float prevHeadY = this.head.yRot;

		this.head.xRot = prevHeadX + headPitch * ((float)Math.PI / 180F);
		this.head.yRot = prevHeadY + netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}