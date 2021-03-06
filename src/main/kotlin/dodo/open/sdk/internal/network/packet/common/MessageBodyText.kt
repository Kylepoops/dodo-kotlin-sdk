package dodo.open.sdk.internal.network.packet.common

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.api.message.TextMessage
import dodo.open.sdk.internal.message.RealTextMessage

data class MessageBodyText(
    val content: String
) : MessageBody {
    override fun deserializeToMessage(
        bot: Bot,
        island: Island,
        channel: Channel,
        sender: Member,
        messageId: Long,
        eventType: Int,
        timestamp: Long
    ): TextMessage {
        return RealTextMessage(
            bot,
            sender,
            island,
            channel,
            content,
            messageId,
            eventType,
            timestamp,
        )
    }
}
