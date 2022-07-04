package dodo.open.sdk.internal.network.packet.websocket

import dodo.open.sdk.internal.network.packet.common.MessageBody
import dodo.open.sdk.internal.network.packet.common.MessageModelMember
import dodo.open.sdk.internal.network.packet.common.MessageModelPersonal
import dodo.open.sdk.internal.network.packet.common.ReferenceModelMember

data class EventBodyChannelMessage(
    val islandId: String,
    val channelId: String,
    val dodoId: String,
    val personal: MessageModelPersonal,
    val member: MessageModelMember,
    val reference: ReferenceModelMember,
    val messageId: String,
    val messageType: Int,
    val messageBody: MessageBody
) : EventBody
