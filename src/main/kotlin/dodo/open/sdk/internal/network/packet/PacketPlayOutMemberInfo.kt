package dodo.open.sdk.internal.network.packet

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class PacketPlayOutMemberInfo(
    val dodoId: String,
    val islandId: String
)
