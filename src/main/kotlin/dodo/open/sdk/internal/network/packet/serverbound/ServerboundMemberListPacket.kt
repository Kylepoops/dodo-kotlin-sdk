package dodo.open.sdk.internal.network.packet.serverbound

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class ServerboundMemberListPacket(
    val islandId: String,
    val maxId: Int,
    val pageSize: Int
)
