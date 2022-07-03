package dodo.open.sdk.internal.network.packet

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class PacketPlayOutIslandId(
    val islandId: String
)
