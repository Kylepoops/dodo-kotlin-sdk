package dodo.open.sdk.internal.network.packet

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class PacketPlayOutChannelId(
    val channelId: String
)