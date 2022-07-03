package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.packet.PacketPlayInIslandInfo
import dodo.open.sdk.internal.network.packet.PacketPlayInIslandList
import dodo.open.sdk.internal.network.packet.PacketPlayInMemberInfo
import dodo.open.sdk.internal.network.packet.PacketPlayInMemberList
import dodo.open.sdk.internal.network.packet.PacketPlayOutEmpty
import dodo.open.sdk.internal.network.packet.PacketPlayOutIslandId
import dodo.open.sdk.internal.network.packet.PacketPlayOutMemberInfo
import dodo.open.sdk.internal.network.packet.PacketPlayOutMemberList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IslandService {
    @POST("island/list")
    fun getIslandList(@Body packet: PacketPlayOutEmpty = PacketPlayOutEmpty()): Call<PacketPlayInIslandList>

    @POST("island/info")
    fun getIslandInfo(@Body packet: PacketPlayOutIslandId): Call<PacketPlayInIslandInfo>

    @POST("member/list")
    fun getMemberList(@Body packet: PacketPlayOutMemberList): Call<PacketPlayInMemberList>

    @POST("member/info")
    fun getMemberInfo(@Body packet: PacketPlayOutMemberInfo): Call<PacketPlayInMemberInfo>
}
