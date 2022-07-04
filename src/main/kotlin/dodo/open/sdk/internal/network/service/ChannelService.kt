package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.clientbound.ClientboundPacket
import dodo.open.sdk.internal.network.packet.clientbound.PacketChannel
import dodo.open.sdk.internal.network.packet.clientbound.PacketMessageId
import dodo.open.sdk.internal.network.packet.clientbound.PacketMessage
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundChannelIdPacket
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundIslandIdPacket
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChannelService {
    @POST("channel/list")
    fun getChannelList(@Body packet: ServerboundIslandIdPacket): Call<ClientboundPacket<List<PacketChannel>>>

    @POST("channel/info")
    fun getChannelInfo(@Body packet: ServerboundChannelIdPacket): Call<ClientboundPacket<PacketChannel>>

    @POST("channel/message/send")
    fun setChannelMessageSend(@Body packet: PacketMessage): Call<ClientboundPacket<PacketMessageId>>
}
