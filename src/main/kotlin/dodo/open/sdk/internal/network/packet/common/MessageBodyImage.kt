package dodo.open.sdk.internal.network.packet.common

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.api.message.Message
import dodo.open.sdk.internal.message.RealImageMessage

data class MessageBodyImage(
    val url: String,
    val width: Int,
    val height: Int,
    val isOriginal: Int
) : MessageBody {
    override fun deserializeToMessage(
        bot: Bot,
        island: Island,
        channel: Channel,
        sender: Member,
        messageId: Long,
        eventType: Int,
        timestamp: Long
    ): Message {
        return RealImageMessage(
            bot,
            url,
            width,
            height,
            isOriginal == 1,
            messageId,
            sender,
            island,
            channel,
            eventType,
            timestamp
        )
    }
}
