package dodo.open.sdk.internal.network.packet

import com.fasterxml.jackson.annotation.JsonProperty

data class PacketPlayInBasicResponse(
    val message: String,
    val status: Int
)
