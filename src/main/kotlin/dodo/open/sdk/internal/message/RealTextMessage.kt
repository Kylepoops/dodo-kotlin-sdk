package dodo.open.sdk.internal.message

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.api.message.TextMessage

data class RealTextMessage(
    override val bot: Bot,
    override val sender: Member,
    override val island: Island,
    override val channel: Channel,
    override val content: String,
    override val messageId: Long,
    override val eventType: Int,
    override val timestamp: Long
) : TextMessage {
    override fun contentToString() = content
}
