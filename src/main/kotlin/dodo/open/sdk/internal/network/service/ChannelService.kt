package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.PacketPlayInChannelInfo
import dodo.open.sdk.internal.network.packet.PacketPlayInChannelList
import dodo.open.sdk.internal.network.packet.PacketPlayInMessageId
import dodo.open.sdk.internal.network.packet.PacketPlayOutChannelId
import dodo.open.sdk.internal.network.packet.PacketPlayOutIslandId
import dodo.open.sdk.internal.network.packet.PacketPlayOutTextMessage
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChannelService {
    @POST("channel/list")
    fun getChannelList(@Body packet: PacketPlayOutIslandId): Call<PacketPlayInChannelList>

    @POST("channel/info")
    fun getChannelInfo(@Body packet: PacketPlayOutChannelId): Call<PacketPlayInChannelInfo>

    @POST("channel/message/send")
    fun setChannelMessageSend(@Body packet: PacketPlayOutTextMessage): Call<PacketPlayInMessageId>
}
