package dodo.open.sdk.internal.message

import dodo.open.sdk.api.message.TextMessage
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.island.RealChannel
import dodo.open.sdk.internal.island.RealIsland
import dodo.open.sdk.internal.member.RealMember

data class RealTextMessage(
    override val bot: RealBot,
    override val sender: RealMember,
    override val island: RealIsland,
    override val channel: RealChannel,
    override val content: String,
    override val messageId: Long,
    override val eventType: Int,
    override val timestamp: Long
) : TextMessage {
    override fun contentToString() = content
}
