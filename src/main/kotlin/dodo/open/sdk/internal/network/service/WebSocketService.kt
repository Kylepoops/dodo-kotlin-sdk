package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.clientbound.ClientboundPacket
import dodo.open.sdk.internal.network.packet.clientbound.PacketWebsocket
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundEmptyPacket
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WebSocketService {
    @POST("websocket/connection")
    fun getWebSocketConnection(@Body packet: ServerboundEmptyPacket = ServerboundEmptyPacket()): Call<ClientboundPacket<PacketWebsocket>>
}