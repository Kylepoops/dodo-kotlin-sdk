package dodo.open.sdk.api.bot

interface BotBuilder {
    fun withClientId(clientId: String): BotBuilder
    fun withToken(token: String): BotBuilder
    fun build(): Bot
}