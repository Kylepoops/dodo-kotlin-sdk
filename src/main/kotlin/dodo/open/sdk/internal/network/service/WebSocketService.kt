package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.PacketPlayInWebSocketConnection
import dodo.open.sdk.internal.network.packet.PacketPlayOutEmpty
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WebSocketService {
    @POST("websocket/connection")
    fun getWebSocketConnection(@Body packet: PacketPlayOutEmpty = PacketPlayOutEmpty()): Call<PacketPlayInWebSocketConnection>
}