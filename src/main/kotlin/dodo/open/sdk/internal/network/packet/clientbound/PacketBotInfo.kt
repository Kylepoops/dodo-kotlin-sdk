package dodo.open.sdk.internal.network.packet.clientbound

data class PacketBotInfo(
    val avatarUrl: String,
    val clientId: String,
    val dodoId: String,
    val nickName: String
)
