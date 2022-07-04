package dodo.open.sdk.internal.bot

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.bot.BotBuilder
import dodo.open.sdk.api.message.Message
import dodo.open.sdk.internal.network.Authorization

class SimpleBotBuilder : BotBuilder {
    private lateinit var clientId: String
    private lateinit var token: String
    private var messageHandler: (Message) -> Unit = {}

    override fun withClientId(clientId: String): BotBuilder {
        this.clientId = clientId
        return this
    }

    override fun withToken(token: String): BotBuilder {
        this.token = token
        return this
    }

    override fun build(): Bot {
        val auth = Authorization(clientId, token)
        return RealBot(auth)
    }
}
