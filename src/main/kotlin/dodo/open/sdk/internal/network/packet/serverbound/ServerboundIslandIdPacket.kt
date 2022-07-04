package dodo.open.sdk.internal.network.packet.serverbound

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class ServerboundIslandIdPacket(
    val islandId: String
)
