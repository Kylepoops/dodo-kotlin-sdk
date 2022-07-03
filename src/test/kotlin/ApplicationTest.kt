import dodo.open.sdk.api.bot.BotFactory

fun main() {
    BotFactory.builder()
        .withClientId("")
        .withToken("")
        .withMessageHandler {
            println("Message: ${it.contentToString()}")
            if (it.contentToString() == "ping") {
                it.channel.sendMessage("pong")
            }
        }
        .build()
}
