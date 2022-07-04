package dodo.open.sdk.internal.network.packet.common

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.api.message.Message

interface MessageBody {
    fun deserializeToMessage(
        bot: Bot,
        island: Island,
        channel: Channel,
        sender: Member,
        messageId: Long,
        eventType: Int,
        timestamp: Long
    ): Message
}
