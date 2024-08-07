package com.sindercube.aileron.client;

import com.sindercube.aileron.content.packets.SmokeStackLaunchPacket;
import com.sindercube.aileron.content.packets.SmokeStackDashPacket;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class AileronNetworking {

	public static void register() {
		PayloadTypeRegistry.playC2S().register(SmokeStackDashPacket.ID, SmokeStackDashPacket.PACKET_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(SmokeStackDashPacket.ID, SmokeStackDashPacket::dash);

		PayloadTypeRegistry.playC2S().register(SmokeStackLaunchPacket.ID, SmokeStackLaunchPacket.PACKET_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(SmokeStackLaunchPacket.ID, SmokeStackLaunchPacket::launch);
	}

}
