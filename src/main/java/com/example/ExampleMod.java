package com.example;

import com.example.events.packet.PacketEvent;
import com.example.events.packet.PacketHandler;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "examplemod", useMetadata = true)
public class ExampleMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(PacketHandler.INSTANCE);
    }

    @SubscribeEvent
    public void onPacketSent(PacketEvent.Sent event) {
        if (event.getPacket() instanceof C01PacketChatMessage) {
            C01PacketChatMessage packet = (C01PacketChatMessage) event.getPacket();
            System.out.println("Sent message: " + packet.getMessage());
        }
    }
}
