package dodo.open.sdk.internal.network.packet

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class PacketPlayOutMemberList(
    val islandId: String,
    val maxId: Int,
    val pageSize: Int
)
