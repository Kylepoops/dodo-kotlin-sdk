package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.clientbound.ClientboundPacket
import dodo.open.sdk.internal.network.packet.clientbound.PacketIsland
import dodo.open.sdk.internal.network.packet.clientbound.PacketMember
import dodo.open.sdk.internal.network.packet.clientbound.PacketMemberList
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundEmptyPacket
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundIslandIdPacket
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundIslandMemberPacket
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundMemberListPacket
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IslandService {
    @POST("island/list")
    fun getIslandList(@Body packet: ServerboundEmptyPacket = ServerboundEmptyPacket()): Call<ClientboundPacket<List<PacketIsland>>>

    @POST("island/info")
    fun getIslandInfo(@Body packet: ServerboundIslandIdPacket): Call<ClientboundPacket<PacketIsland>>

    @POST("member/list")
    fun getMemberList(@Body packet: ServerboundMemberListPacket): Call<ClientboundPacket<PacketMemberList>>

    @POST("member/info")
    fun getMemberInfo(@Body packet: ServerboundIslandMemberPacket): Call<ClientboundPacket<PacketMember>>
}
