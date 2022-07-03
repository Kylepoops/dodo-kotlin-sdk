package dodo.open.sdk.api.bot

import dodo.open.sdk.api.message.Message

interface BotBuilder {
    fun withClientId(clientId: String): BotBuilder
    fun withToken(token: String): BotBuilder
    fun withMessageHandler(handler: (Message) -> Unit): BotBuilder
    fun build(): Bot
}