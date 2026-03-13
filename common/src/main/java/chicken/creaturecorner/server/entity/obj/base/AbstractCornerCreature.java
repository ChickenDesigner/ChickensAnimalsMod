package chicken.creaturecorner.server.entity.obj.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public abstract class AbstractCornerCreature extends Animal {

    protected static final EntityDataAccessor<Integer> FOOD_LEVEL = SynchedEntityData.defineId(AbstractCornerCreature.class, EntityDataSerializers.INT);
    public AbstractCornerCreature(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FOOD_LEVEL, maxFood());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("FoodLevel", this.getFoodLevel());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFoodLevel(compound.getInt("FoodLevel"));
    }

    @Override
    public void tick() {
        if(this.hasHunger()) {
            if (random.nextFloat() <= 0.07 && this.getFoodLevel()>0) {
                int prevFood = this.getFoodLevel();
                this.setFoodLevel(prevFood - 1);
                if (this.getFoodLevel() <= 15) {
                    this.starve();
                }
            }
        }
        super.tick();
    }

    public boolean hasHunger() {
        return false;
    }

    protected void starve() {
        //this.hurt(level().damageSources().starve(), 1);
    }

    public boolean isHungry() {
        return getFoodLevel() <= maxFood()/2;
    }

    public boolean isAlmostStarving() {
        return getFoodLevel() <= maxFood()/10;
    }

    public void setFoodLevel(int foodLevel) {
        this.entityData.set(FOOD_LEVEL, foodLevel);
    }

    public int getFoodLevel() {
        return this.entityData.get(FOOD_LEVEL);
    }

    public int maxFood() {
        return 100;
    }

    public boolean hasChildModel() {
        return false;
    }

    public boolean childVariants() {
        return false;
    }

    public String getVariantName() {
        return "";
    }
}
