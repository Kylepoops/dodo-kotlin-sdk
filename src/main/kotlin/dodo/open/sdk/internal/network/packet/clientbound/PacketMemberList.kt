package dodo.open.sdk.internal.network.packet.clientbound

data class PacketMemberList(
    val maxId: Int,
    val list: List<PacketMember>
)