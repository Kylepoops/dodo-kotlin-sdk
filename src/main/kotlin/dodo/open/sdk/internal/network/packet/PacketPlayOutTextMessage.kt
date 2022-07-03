package dodo.open.sdk.internal.network.packet

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket

@DodoRequestPacket
data class PacketPlayOutTextMessage private constructor(
    val channelId: String,
    val messageBody: MessageBody,
    val messageType: Int
) {
    constructor(channelId: String, message: String) : this(channelId, MessageBody(message), 1)

    data class MessageBody(
        val content: String
    )
}
