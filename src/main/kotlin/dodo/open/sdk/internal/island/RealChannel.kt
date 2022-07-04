package dodo.open.sdk.internal.island

import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.message.ImageMessage
import dodo.open.sdk.api.message.Message
import dodo.open.sdk.api.message.TextMessage
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.network.exception.DodoException
import dodo.open.sdk.internal.network.packet.clientbound.PacketMessage
import dodo.open.sdk.internal.network.packet.common.MessageBodyImage
import dodo.open.sdk.internal.network.packet.common.MessageBodyText
import dodo.open.sdk.internal.util.asyncExecute
import java.util.concurrent.CompletableFuture

data class RealChannel(
    override val bot: RealBot,
    override val channelId: String,
    override val channelName: String,
    override val channelType: Int,
    override val island: RealIsland,
    override val defaultFlag: Int,
    override val groupId: String,
    override val groupName: String
) : Channel {
    override fun sendMessage(message: String) = bot.services.channel
        .setChannelMessageSend(PacketMessage(channelId, MessageBodyText(message), 1))
        .asyncExecute()
        .thenApply {
            if (it.status != 0) { throw DodoException(it.message) }
            it.data.messageId
        }
        .exceptionally { throw it }

    override fun sendMessage(message: Message): CompletableFuture<Long> {
        when(message) {
            is TextMessage -> return sendMessage(message.content)
            is ImageMessage -> {
                val messageBody = MessageBodyImage(message.url, message.width, message.height, if (message.isOriginal) 1 else 0)
                return bot.services.channel
                    .setChannelMessageSend(PacketMessage(channelId, messageBody, 2))
                    .asyncExecute()
                    .thenApply {
                        if (it.status != 0) { throw DodoException(it.message) }
                        it.data.messageId
                    }
                    .exceptionally { throw it }
            }
            else -> throw IllegalArgumentException("Unsupported message type: ${message::class.java.name}")
        }
    }
}
