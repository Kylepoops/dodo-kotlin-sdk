package dodo.open.sdk.internal.network.packet.clientbound

import dodo.open.sdk.internal.network.packet.common.MessageBody

data class PacketMessage(
    val channelId: String,
    val messageBody: MessageBody,
    val messageType: Int
)
