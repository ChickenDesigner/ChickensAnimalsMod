package chicken.creaturecorner.client.model.entity.caracara;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import chicken.creaturecorner.client.animation.CaracaraAnims;
import chicken.creaturecorner.server.entity.obj.Caracara;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CaracaraModel<T extends Caracara> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart caracara;
	private final ModelPart fly_rot;
	private final ModelPart leg2;
	private final ModelPart claws2;
	private final ModelPart two;
	private final ModelPart leg1;
	private final ModelPart claws1;
	private final ModelPart one;
	private final ModelPart top;
	private final ModelPart look;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart wing2;
	private final ModelPart feathers2;
	private final ModelPart wing1;
	private final ModelPart feathers1;
	private final ModelPart tail;

	public CaracaraModel(ModelPart root) {
		this.root = root.getChild("root");
		this.caracara = this.root.getChild("caracara");
		this.fly_rot = this.caracara.getChild("fly_rot");
		this.leg2 = this.fly_rot.getChild("leg2");
		this.claws2 = this.leg2.getChild("claws2");
		this.two = this.claws2.getChild("two");
		this.leg1 = this.fly_rot.getChild("leg1");
		this.claws1 = this.leg1.getChild("claws1");
		this.one = this.claws1.getChild("one");
		this.top = this.fly_rot.getChild("top");
		this.look = this.top.getChild("look");
		this.head = this.look.getChild("head");
		this.body = this.top.getChild("body");
		this.wing2 = this.body.getChild("wing2");
		this.feathers2 = this.wing2.getChild("feathers2");
		this.wing1 = this.body.getChild("wing1");
		this.feathers1 = this.wing1.getChild("feathers1");
		this.tail = this.body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition caracara = root.addOrReplaceChild("caracara", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition fly_rot = caracara.addOrReplaceChild("fly_rot", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -6.0F));

		PartDefinition leg2 = fly_rot.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(3.0F, 5.0F, 6.0F));

		PartDefinition claws2 = leg2.addOrReplaceChild("claws2", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition claws2_r1 = claws2.addOrReplaceChild("claws2_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition two = claws2.addOrReplaceChild("two", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition two_r1 = two.addOrReplaceChild("two_r1", CubeListBuilder.create().texOffs(42, 10).mirror().addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition leg1 = fly_rot.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offset(-3.0F, 5.0F, 6.0F));

		PartDefinition claws1 = leg1.addOrReplaceChild("claws1", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition claws1_r1 = claws1.addOrReplaceChild("claws1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition one = claws1.addOrReplaceChild("one", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition one_r1 = one.addOrReplaceChild("one_r1", CubeListBuilder.create().texOffs(42, 10).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition top = fly_rot.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 6.0F));

		PartDefinition look = top.addOrReplaceChild("look", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, -5.0F));

		PartDefinition head = look.addOrReplaceChild("head", CubeListBuilder.create().texOffs(35, 20).addBox(-2.5F, -9.0F, -3.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(40, 36).addBox(-2.5F, -9.0F, 2.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-1.0F, -5.0F, -9.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.01F))
		.texOffs(0, 38).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = top.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -9.0F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(14, 26).addBox(0.0F, -3.0F, 0.0F, 1.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -3.0F, 12.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(4.0F, -4.0F, -9.0F));

		PartDefinition feathers2 = wing2.addOrReplaceChild("feathers2", CubeListBuilder.create().texOffs(14, 7).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, -1.0F, 0.0F));

		PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 12.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.01F))
		.texOffs(0, 20).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, -9.0F));

		PartDefinition feathers1 = wing1.addOrReplaceChild("feathers1", CubeListBuilder.create().texOffs(14, 7).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, -1.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(29, 0).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Caracara entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (!entity.isInWaterOrBubble() && !entity.onGround()){
			if (entity.isDiving())
				this.animate(entity.idleAnimationState, CaracaraAnims.DIVE, ageInTicks, 1);
			else
				this.animate(entity.idleAnimationState, CaracaraAnims.FLY, ageInTicks, 1);
		}else {
			this.animate(entity.idleAnimationState, CaracaraAnims.IDLE, ageInTicks, 1);

			if (entity.isAggressive())
				this.animateWalk(CaracaraAnims.RUN, limbSwing*2, limbSwingAmount*2, 2f, 2f);
			else
				this.animateWalk(CaracaraAnims.WALK, limbSwing*2, limbSwingAmount*2, 2f, 2f);
		}

		float prevHeadX = this.head.xRot;
		float prevHeadY = this.head.yRot;

		this.head.xRot = Mth.lerp((float) entity.getInFlightTicks() /5, prevHeadX + headPitch * ((float)Math.PI / 180F), 0);
		this.head.yRot = Mth.lerp((float) entity.getInFlightTicks() /5, prevHeadY + netHeadYaw * ((float)Math.PI / 180F), 0);

		this.fly_rot.xRot = Mth.lerp((float) entity.getInFlightTicks()/5,0,headPitch * ((float)Math.PI / 180F));
		this.fly_rot.yRot = Mth.lerp((float) entity.getInFlightTicks()/5,0,netHeadYaw * ((float)Math.PI / 180F));
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