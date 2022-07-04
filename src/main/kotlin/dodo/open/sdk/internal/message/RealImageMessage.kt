package dodo.open.sdk.internal.message

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.api.message.ImageMessage

data class RealImageMessage(
    override val bot: Bot,
    override val url: String,
    override val width: Int,
    override val height: Int,
    override val isOriginal: Boolean,
    override val messageId: Long,
    override val sender: Member,
    override val island: Island,
    override val channel: Channel,
    override val eventType: Int,
    override val timestamp: Long
) : ImageMessage {
    override fun contentToString(): String {
        return "[IMAGE]$url[\\IMAGE]"
    }
}
