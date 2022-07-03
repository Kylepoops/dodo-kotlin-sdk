package dodo.open.sdk.internal.network.packet

data class PacketPlayInIslandInfo(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val coverUrl: String,
        val defaultChannelId: String,
        val description: String?,
        val islandId: String,
        val islandName: String,
        val memberCount: Int,
        val onlineMemberCount: Int,
        val systemChannelId: String
    )
}
