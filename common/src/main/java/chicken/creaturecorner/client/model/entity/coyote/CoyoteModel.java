package chicken.creaturecorner.client.model.entity.coyote;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import chicken.creaturecorner.client.animation.CoyoteAnims;
import chicken.creaturecorner.server.entity.obj.CoyoteEntity;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CoyoteModel<T extends CoyoteEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart coyote;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart bally;
	private final ModelPart fur;
	private final ModelPart head_rot;
	private final ModelPart head;
	private final ModelPart tongue1;
	private final ModelPart tongue2;
	private final ModelPart ear2;
	private final ModelPart ear1;

	public CoyoteModel(ModelPart root) {
		this.root = root.getChild("root");
		this.coyote = this.root.getChild("coyote");
		this.leg1 = this.coyote.getChild("leg1");
		this.leg2 = this.coyote.getChild("leg2");
		this.leg3 = this.coyote.getChild("leg3");
		this.leg4 = this.coyote.getChild("leg4");
		this.body = this.coyote.getChild("body");
		this.tail = this.body.getChild("tail");
		this.bally = this.body.getChild("bally");
		this.fur = this.bally.getChild("fur");
		this.head_rot = this.body.getChild("head_rot");
		this.head = this.head_rot.getChild("head");
		this.tongue1 = this.head.getChild("tongue1");
		this.tongue2 = this.tongue1.getChild("tongue2");
		this.ear2 = this.head.getChild("ear2");
		this.ear1 = this.head.getChild("ear1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition coyote = root.addOrReplaceChild("coyote", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg1 = coyote.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(26, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -6.0F, -4.5F));

		PartDefinition leg2 = coyote.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(18, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -6.0F, -4.5F));

		PartDefinition leg3 = coyote.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(26, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -6.0F, 4.5F));

		PartDefinition leg4 = coyote.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(18, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -6.0F, 4.5F));

		PartDefinition body = coyote.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 4.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 7).addBox(-1.5F, 6.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bally = body.addOrReplaceChild("bally", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -1.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -9.0F));

		PartDefinition fur = bally.addOrReplaceChild("fur", CubeListBuilder.create().texOffs(0, 7).addBox(3.0F, 0.0F, -1.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.01F))
		.texOffs(0, 7).addBox(-3.0F, 0.0F, -1.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.01F))
		.texOffs(0, 13).addBox(-2.0F, 0.0F, 1.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.01F))
		.texOffs(0, 13).addBox(2.0F, 0.0F, 1.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.01F))
		.texOffs(0, 5).addBox(0.0F, -7.0F, -1.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition head_rot = body.addOrReplaceChild("head_rot", CubeListBuilder.create(), PartPose.offset(-0.5F, -1.0F, -10.0F));

		PartDefinition head = head_rot.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, 0.0F, -9.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 17).addBox(-2.5F, -3.0F, -4.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-4.5F, -3.0F, -1.0F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tongue1 = head.addOrReplaceChild("tongue1", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.75F, 0.0F, -7.0F));

		PartDefinition tongue2 = tongue1.addOrReplaceChild("tongue2", CubeListBuilder.create().texOffs(4, 7).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition ear2 = head.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(6, 28).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.0F, 0.0F));

		PartDefinition ear1 = head.addOrReplaceChild("ear1", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (entity.isInSittingPose()){
			this.animate(entity.idleAnimationState, CoyoteAnims.SIT, ageInTicks, 1);
		}else {
			this.animate(entity.idleAnimationState, CoyoteAnims.BABY_IDLE, ageInTicks, 1);

			if (entity.isSprinting() || entity.isAggressive()){
				this.animateWalk(CoyoteAnims.RUN, limbSwing, limbSwingAmount, 1.5f, 1f);
			}else {
				this.animateWalk(CoyoteAnims.WALK, limbSwing*2, limbSwingAmount*2, 2f, 2f);
			}

			this.animate(entity.scratchAnimationState, CoyoteAnims.EAR_SCRATCH, ageInTicks, 1);
		}


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