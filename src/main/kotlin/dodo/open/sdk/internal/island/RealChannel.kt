package dodo.open.sdk.internal.island

import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.network.exception.DodoException
import dodo.open.sdk.internal.network.packet.PacketPlayOutTextMessage
import dodo.open.sdk.internal.util.asyncExecute

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
        .setChannelMessageSend(PacketPlayOutTextMessage(channelId, message))
        .asyncExecute()
        .thenApply {
            if (it.status != 0) { throw DodoException(it.message) }
            it.data.messageId
        }
        .exceptionally { throw it }
}
