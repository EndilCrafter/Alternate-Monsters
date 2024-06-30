package com.endilcrafter.alternate_monsters;

import com.endilcrafter.alternate_monsters.client.AMClientSetup;
import com.endilcrafter.alternate_monsters.common.entity.Crying;
import com.endilcrafter.alternate_monsters.common.register.AMEntityTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;


@Mod(AlternateMonsters.MODID)
public class AlternateMonsters {
    public static final String MODID = "alternate_monsters";

    public AlternateMonsters(IEventBus modEventBus, ModContainer modContainer) {
        AMEntityTypes.ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(this::addAttributes);
    }

    @SubscribeEvent
    private void addAttributes(final EntityAttributeCreationEvent event) {
        event.put(AMEntityTypes.CRYING.get(), Crying.createAttributes().build());
    }
}
