package dodo.open.sdk.api.island

import dodo.open.sdk.api.bot.Bot
import java.util.concurrent.CompletableFuture

interface Channel {
    val bot: Bot
    val channelId: String
    val channelName: String
    val channelType: Int
    val island: Island
    val defaultFlag: Int
    val groupId: String
    val groupName: String

    fun sendMessage(message: String): CompletableFuture<Long>
}