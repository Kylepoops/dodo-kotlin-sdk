package dodo.open.sdk.internal.network.packet


import com.fasterxml.jackson.annotation.JsonProperty

data class PacketPlayInMessageId(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val messageId: Long
    )
}