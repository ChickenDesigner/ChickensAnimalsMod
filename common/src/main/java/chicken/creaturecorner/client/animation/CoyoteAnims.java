package chicken.creaturecorner.client.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
/**
 * Made with Blockbench 5.0.7
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Author
 */
public class CoyoteAnims {
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.5F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.75F, 0.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.75F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(1.5F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1.0F).looping()
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 1.3F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 1.3F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.3F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.16F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-13.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 1.3F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-4.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-4.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(1.64F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(1.64F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition RUN = AnimationDefinition.Builder.withLength(0.5F).looping()
			.addAnimation("coyote", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("coyote", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 2.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 1.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-11.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(91.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(-0.25F, 1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(-0.25F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(-0.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(-0.25F, 1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(91.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.25F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.25F, 1.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.25F, 2.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(87.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(94.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(81.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(56.21F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(68.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(87.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.06F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-9.96F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(8.19F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(9.06F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, 36.09F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-23.81F, 0.0F, 34.79F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, 28.84F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-10.21F, 0.0F, 7.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, 16.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, 36.09F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, -36.09F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-23.81F, 0.0F, -34.79F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-34.79F, 0.0F, -21.19F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-10.21F, 0.0F, -7.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, -16.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-34.79F, 0.0F, -23.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, -36.09F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition TAMED = AnimationDefinition.Builder.withLength(0.5F).looping()
			.addAnimation("tongue1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tongue1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(-0.25F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tongue2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 6.43F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 9.85F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -9.85F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 6.43F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tongue2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition SIT = AnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.5F, 1.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.5F, 1.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, -22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-44.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-43.54F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-43.54F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(-44.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -6.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -6.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(114.0F, -6.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(112.5F, -2.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(114.0F, 6.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(112.5F, 2.5F, 7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(114.0F, -6.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.71F, 0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.71F, 0.7F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(43.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(45.44F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(48.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(46.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.05F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.1F, 0.95F, 1.1F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.scaleVec(1.05F, 0.98F, 1.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0F, 1.05F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.05F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.1F, 0.95F, 1.1F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.scaleVec(1.05F, 0.98F, 1.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0F, 1.05F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition HOWL = AnimationDefinition.Builder.withLength(3.1667F).looping()
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 2.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.2F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.scaleVec(1.0F, 1.35F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.scaleVec(1.0F, 1.45F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.scaleVec(1.0F, 1.55F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 2.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.2F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.scaleVec(1.0F, 1.35F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.scaleVec(1.0F, 1.45F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.scaleVec(1.0F, 1.55F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-5.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-15.9F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-16.04F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-17.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4583F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-22.5F, 6.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-36.85F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-46.8F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-50.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5833F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition EAR_SCRATCH = AnimationDefinition.Builder.withLength(2.5417F).looping()
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-120.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.posVec(3.0F, 1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(3.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.posVec(3.0F, 1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.posVec(3.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.posVec(3.0F, 1.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.posVec(3.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(3.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(1.0F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.35F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.6F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-3.9F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(40.0F, -15.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(27.5F, -27.5F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(27.5F, -27.5F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(27.3905F, 12.0199F, 10.6046F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(17.0536F, -7.2549F, -16.5065F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-1.2151F, -1.449F, 10.4243F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-10.5F, -2.5F, 6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-0.7F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.posVec(-1.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625F, KeyframeAnimations.degreeVec(7.5F, -22.5F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(5.0F, 1.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.643F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -8.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-4.5F, -3.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-4.5F, -3.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-2.04F, -1.29F, 3.02F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.0F, 0.4F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.1F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-2.0F, -3.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-2.0F, -3.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.1F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg_base3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.875F, KeyframeAnimations.posVec(-1.5F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BABY_IDLE = AnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.5F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.75F, 0.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.75F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(1.5F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-4.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(4.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -11.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 7.0F, 11.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, -7.0F, 11.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -11.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BABY_WALK = AnimationDefinition.Builder.withLength(1.0F).looping()
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 1.0F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 1.0F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.0F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.22F, 0.16F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-13.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(38.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(34.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-21.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-13.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.8F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 1.0F, -1.4F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, -0.2F, -1.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 8.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(3.0F, 0.0F, -8.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 8.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-6.0F, 7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.0F, -7.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(1.64F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(1.64F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(1.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.23F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 22.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, -22.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BABY_RUN = AnimationDefinition.Builder.withLength(0.5F).looping()
			.addAnimation("coyote", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("coyote", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 2.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 1.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-11.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(91.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(-0.25F, 0.5F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(-0.25F, 1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(-0.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(-0.25F, 0.5F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-44.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(91.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.25F, 1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.25F, 0.5F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.25F, 1.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.06F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-27.46F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(10.69F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.06F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, -36.09F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-23.81F, 0.0F, -34.79F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-34.79F, 0.0F, -21.19F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-10.21F, 0.0F, -7.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, -16.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-34.79F, 0.0F, -23.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, -36.09F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, 36.09F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-23.81F, 0.0F, 34.79F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, 28.84F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-10.21F, 0.0F, 7.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-36.09F, 0.0F, 16.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-8.91F, 0.0F, 36.09F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(87.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(94.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(81.84F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(56.21F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(68.16F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(87.86F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BABY_SIT = AnimationDefinition.Builder.withLength(2.0F).looping()
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.2F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.2F, 0.2F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, -22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-44.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-43.54F, -0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-43.54F, 0.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(-44.58F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -3.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -3.25F, -1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(43.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(45.44F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(48.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(46.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.91F, -0.7F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(8.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-6.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(8.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(94.0F, -6.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(94.0F, -2.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(94.0F, 6.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(94.0F, 2.5F, 7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(94.0F, -6.0F, 2.5F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.29F, 0.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.29F, 0.7F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(6.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BABY_EAR_SCRATCH = AnimationDefinition.Builder.withLength(2.5417F).looping()
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-4.5F, -3.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-4.5F, -3.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-2.04F, -1.29F, 3.02F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.1F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-135.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-120.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(3.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg4", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, 1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(2.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.posVec(2.0F, 1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.posVec(2.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.posVec(2.0F, 1.0F, -3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.posVec(2.0F, -0.15F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(0.5F, 0.0F, -0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.35F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.6F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-3.9F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-9.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-4.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -22.5F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(5.0F, -22.5F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625F, KeyframeAnimations.degreeVec(7.5F, -22.5F, 10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(5.0F, 5.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(5.0F, 1.0F, -2.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.643F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 14.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -8.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("ear2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, 1.13F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-18.0F, 22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-10.5F, -2.5F, 6.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-0.7F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("bally", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.posVec(-1.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(-1.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(40.0F, -15.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(27.5F, -27.5F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(27.5F, -27.5F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(37.5F, -22.5F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(27.3905F, 12.0199F, 10.6046F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(17.0536F, -7.2549F, -16.5065F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-1.2151F, -1.449F, 10.4243F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-9.5F, -3.0F, 17.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-9.5F, -3.0F, 17.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-2.04F, -1.29F, 3.02F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(-2.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.8333F, KeyframeAnimations.posVec(-0.9F, 0.4F, -0.45F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base1", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.1F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-2.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(5.5F, -18.0F, -8.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(5.5F, -18.0F, -8.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg_base2", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.scaleVec(1.0F, 1.1F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("leg_base3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base3", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.6667F, KeyframeAnimations.posVec(-1.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.875F, KeyframeAnimations.posVec(-1.5F, 0.0F, 0.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("leg_base4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();
}