package dodo.open.sdk.api.bot

import dodo.open.sdk.api.bot.BotBuilder
import dodo.open.sdk.internal.bot.SimpleBotBuilder

object BotFactory {
    fun builder(): BotBuilder {
        return SimpleBotBuilder()
    }
}