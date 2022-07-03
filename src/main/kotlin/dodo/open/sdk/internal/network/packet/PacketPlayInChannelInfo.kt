package dodo.open.sdk.internal.network.packet

data class PacketPlayInChannelInfo(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val channelId: String,
        val channelName: String,
        val channelType: Int,
        val defaultFlag: Int,
        val groupId: String,
        val groupName: String,
        val islandId: String
    )
}