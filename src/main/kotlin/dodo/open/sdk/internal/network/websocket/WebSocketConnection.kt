package dodo.open.sdk.internal.network.websocket

import dodo.open.sdk.api.event.ChannelMessageEvent
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.island.RealChannel
import dodo.open.sdk.internal.island.RealIsland
import dodo.open.sdk.internal.member.RealMember
import dodo.open.sdk.internal.message.RealTextMessage
import dodo.open.sdk.internal.network.packet.common.MessageBodyText
import dodo.open.sdk.internal.network.packet.websocket.EventBodyChannelMessage
import dodo.open.sdk.internal.network.packet.websocket.PacketEvent
import dodo.open.sdk.internal.util.jsonMapper
import dodo.open.sdk.internal.util.referType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import java.util.concurrent.TimeUnit

class WebSocketConnection(val bot: RealBot, endpoint: String) : WebSocketListener() {
    val webSocket: WebSocket

    init {
        val client = OkHttpClient.Builder()
            .pingInterval(25, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url(endpoint)
            .build()

        webSocket = client.newWebSocket(request, this)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        val json = bytes.utf8()
        val node = jsonMapper.readTree(json)

        val type = node.get("data")
            .get("eventType")
            .asInt(0)

        when (type) {
            2001 -> handleChannelMessage(jsonMapper.readValue(json, referType<PacketEvent<EventBodyChannelMessage>>()))
        }
    }

    private fun handleChannelMessage(packet: PacketEvent<EventBodyChannelMessage>) {
        val island = bot.getIsland(packet.data.eventBody.islandId).get()
        val channel = island.getChannel(packet.data.eventBody.channelId)
        val member = island.getMember(packet.data.eventBody.dodoId)
        val messageId = packet.data.eventBody.messageId.toLong()
        val timestamp = packet.data.timestamp
        val messageType = packet.data.eventBody.messageType
        val eventType = packet.data.eventType.toInt()

        val message = packet.data.eventBody.messageBody.deserializeToMessage(
            bot,
            island,
            channel.get(),
            member.get(),
            messageId,
            eventType,
            timestamp,
        )

        bot.globalEventBus.post(ChannelMessageEvent(message))
    }
}
