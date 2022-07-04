package dodo.open.sdk.internal.network.packet.clientbound

data class PacketIsland(
    val coverUrl: String,
    val defaultChannelId: String,
    val description: String?,
    val islandId: String,
    val islandName: String,
    val memberCount: Int,
    val onlineMemberCount: Int,
    val systemChannelId: String
)
