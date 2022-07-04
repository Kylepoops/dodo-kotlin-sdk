package dodo.open.sdk.internal.network.packet.clientbound

data class PacketChannel(
    val channelId: String,
    val channelName: String,
    val channelType: Int,
    val defaultFlag: Int,
    val groupId: String,
    val groupName: String,
    val islandId: String?
)
