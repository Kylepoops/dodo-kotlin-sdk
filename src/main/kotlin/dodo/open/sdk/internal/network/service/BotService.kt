package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.clientbound.ClientboundPacket
import dodo.open.sdk.internal.network.packet.clientbound.PacketBotInfo
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundIslandIdPacket
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BotService {
    @POST("bot/info")
    fun getBotInfo(): Call<ClientboundPacket<PacketBotInfo>>

    @POST("bot/island/leave")
    fun setBotIslandLeave(@Body packet: ServerboundIslandIdPacket): Call<ClientboundPacket<Void>>
}
