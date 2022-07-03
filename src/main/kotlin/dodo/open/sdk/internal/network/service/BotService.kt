package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.PacketPlayInBasicResponse
import dodo.open.sdk.internal.network.packet.PacketPlayInBotInfo
import dodo.open.sdk.internal.network.packet.PacketPlayOutIslandId
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BotService {
    @POST("bot/info")
    fun getBotInfo(): Call<PacketPlayInBotInfo>

    @POST("bot/island/leave")
    fun setBotIslandLeave(@Body packet: PacketPlayOutIslandId): Call<PacketPlayInBasicResponse>
}
