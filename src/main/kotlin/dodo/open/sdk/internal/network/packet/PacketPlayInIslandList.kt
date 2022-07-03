package dodo.open.sdk.internal.network.packet


import com.fasterxml.jackson.annotation.JsonProperty

data class PacketPlayInIslandList(
    val data: List<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val coverUrl: String,
        val defaultChannelId: String,
        val islandId: String,
        val islandName: String,
        val memberCount: Int,
        val onlineMemberCount: Int,
        val systemChannelId: String
    )
}