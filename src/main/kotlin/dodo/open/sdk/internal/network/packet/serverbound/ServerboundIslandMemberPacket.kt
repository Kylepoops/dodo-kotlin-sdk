package dodo.open.sdk.internal.network.packet.serverbound

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class ServerboundIslandMemberPacket(
    val dodoId: String,
    val islandId: String
)
