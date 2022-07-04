package dodo.open.sdk.internal.network.packet.websocket

import dodo.open.sdk.internal.network.packet.common.MessageBody
import dodo.open.sdk.internal.network.packet.common.MessageModelPersonal

data class EventBodyPersonalMessage(
    val dodoId: String,
    val personal: MessageModelPersonal,
    val messageId: String,
    val messageType: Int,
    val messageBody: MessageBody
)
