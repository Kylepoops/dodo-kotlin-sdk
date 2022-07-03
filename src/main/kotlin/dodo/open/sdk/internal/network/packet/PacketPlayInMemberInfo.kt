package dodo.open.sdk.internal.network.packet

data class PacketPlayInMemberInfo(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val avatarUrl: String,
        val dodoId: String,
        val isBot: Int,
        val islandId: String,
        val joinTime: String,
        val level: Int,
        val nickName: String,
        val onlineDevice: Int,
        val onlineStatus: Int,
        val personalNickName: String,
        val sex: Int
    )
}
