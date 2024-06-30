package com.endilcrafter.alternate_monsters.common.entity;

import com.endilcrafter.alternate_monsters.common.register.AMEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class SmallCryingBall extends Fireball {
    public SmallCryingBall(EntityType<? extends SmallCryingBall> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SmallCryingBall(Level p_37375_, LivingEntity p_37376_, Vec3 p_347501_) {
        super(AMEntityTypes.SMALL_CRYING_BALL.get(), p_37376_, p_347501_, p_37375_);
    }

    public SmallCryingBall(Level p_37367_, double p_37368_, double p_37369_, double p_37370_, Vec3 p_347543_) {
        super(AMEntityTypes.SMALL_CRYING_BALL.get(), p_37368_, p_37369_, p_37370_, p_347543_, p_37367_);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity1 = pResult.getEntity();
            Entity $$4 = this.getOwner();
            DamageSource $$6 = this.damageSources().thrown(this, $$4);
            double d0 = entity1.getX() - this.getX();
            double d1 = entity1.getZ() - this.getZ();
            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
            entity1.push(d0 / d2 * 2.5, 0.2, d1 / d2 * 2.5);
            entity1.hurt($$6, 6.0F);

        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }
}
