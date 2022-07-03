package dodo.open.sdk.internal.network.websocket

import com.fasterxml.jackson.databind.DatabindException
import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.island.RealChannel
import dodo.open.sdk.internal.island.RealIsland
import dodo.open.sdk.internal.member.RealMember
import dodo.open.sdk.internal.message.RealTextMessage
import dodo.open.sdk.internal.network.packet.websocket.PacketPlayInTextMessage
import dodo.open.sdk.internal.util.jsonMapper
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
        try {
            val packet = jsonMapper.readValue(json, PacketPlayInTextMessage::class.java)
            val island = bot.getIsland(packet.data.eventBody.islandId).get() as RealIsland

            val message = RealTextMessage(
                bot,
                island.getMember(packet.data.eventBody.dodoId).get() as RealMember,
                island,
                island.getChannel(packet.data.eventBody.channelId).get() as RealChannel,
                packet.data.eventBody.messageBody.content,
                packet.data.eventBody.messageId,
                packet.data.eventBody.messageType,
                packet.data.timestamp
            )

            bot.onMessage(message)
        } catch (_: DatabindException) {
            println("Invalid JSON: $json")
        }
    }
}
