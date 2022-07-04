package dodo.open.sdk.internal.network.websocket

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DatabindException
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
import org.greenrobot.eventbus.EventBus
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

        try {
            val packet = jsonMapper.readValue(json, referType<PacketEvent<EventBodyChannelMessage>>())
            handleTextMessage(packet)
        } catch (ex: Throwable) {
            ex.printStackTrace()
        }
    }

    fun handleTextMessage(packet: PacketEvent<EventBodyChannelMessage>) {
        val island = bot.getIsland(packet.data.eventBody.islandId).get() as RealIsland

        val message = RealTextMessage(
            bot,
            island.getMember(packet.data.eventBody.dodoId).get() as RealMember,
            island,
            island.getChannel(packet.data.eventBody.channelId).get() as RealChannel,
            (packet.data.eventBody.messageBody as MessageBodyText).content,
            packet.data.eventBody.messageId.toLong(),
            packet.data.eventBody.messageType,
            packet.data.timestamp
        )

        EventBus.getDefault().post(ChannelMessageEvent(message))
    }
}
