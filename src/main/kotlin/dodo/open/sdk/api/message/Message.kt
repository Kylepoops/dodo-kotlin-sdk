package dodo.open.sdk.api.message

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member

interface Message {
    val bot: Bot
    val messageId: Long
    val sender: Member
    val island: Island
    val channel: Channel
    val eventType: Int
    val timestamp: Long
    fun contentToString(): String
}
