package dodo.open.sdk.internal.network.packet.clientbound

data class PacketMember(
    val avatarUrl: String,
    val dodoId: String,
    val isBot: Int,
    val islandId: String?,
    val joinTime: String,
    val level: Int,
    val nickName: String,
    val onlineDevice: Int,
    val onlineStatus: Int,
    val personalNickName: String,
    val sex: Int
)
