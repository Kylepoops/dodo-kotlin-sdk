package dodo.open.sdk.internal.network.packet.serverbound

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class ServerboundChannelIdPacket(
    val channelId: String
)