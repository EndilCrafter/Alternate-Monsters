package com.endilcrafter.alternate_monsters.common.register;

import com.endilcrafter.alternate_monsters.AlternateMonsters;
import com.endilcrafter.alternate_monsters.common.entity.Crying;
import com.endilcrafter.alternate_monsters.common.entity.SmallCryingBall;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AMEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AlternateMonsters.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<Crying>> CRYING = register("crying",
            () -> EntityType.Builder.of(Crying::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 1.8F).clientTrackingRange(8));
    public static final DeferredHolder<EntityType<?>, EntityType<SmallCryingBall>> SMALL_CRYING_BALL = register("small_crying_ball",
            () -> EntityType.Builder.<SmallCryingBall>of(SmallCryingBall::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10));

    private static <T extends Entity>
    DeferredHolder<EntityType<?>, EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> prepare) {
        return ENTITY_TYPES.register(name, () -> prepare.get().build(AlternateMonsters.MODID + ":" + name));
    }
}
