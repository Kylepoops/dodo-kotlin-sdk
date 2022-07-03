package dodo.open.sdk.internal.network.packet

import com.fasterxml.jackson.annotation.JsonProperty

data class PacketPlayInBotInfo(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val avatarUrl: String,
        val clientId: String,
        val dodoId: String,
        val nickName: String
    )
}
