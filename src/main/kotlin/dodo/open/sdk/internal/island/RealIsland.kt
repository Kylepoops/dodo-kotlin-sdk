package dodo.open.sdk.internal.island

import dodo.open.sdk.api.island.Channel
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.api.member.Member
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.member.RealMember
import dodo.open.sdk.internal.network.packet.PacketPlayOutChannelId
import dodo.open.sdk.internal.network.packet.PacketPlayOutIslandId
import dodo.open.sdk.internal.network.packet.PacketPlayOutMemberInfo
import dodo.open.sdk.internal.network.packet.PacketPlayOutMemberList
import dodo.open.sdk.internal.util.asyncExecute
import java.util.concurrent.CompletableFuture

data class RealIsland(
    override val bot: RealBot,
    override val coverUrl: String,
    override val defaultChannelId: String,
    override val islandId: String,
    override val islandName: String,
    override val memberCount: Int,
    override val onlineMemberCount: Int,
    override val systemChannelId: String,
    override val description: String
) : Island {

    override fun getChannels(): CompletableFuture<List<Channel>> = bot.services.channel
        .getChannelList(PacketPlayOutIslandId(islandId))
        .asyncExecute()
        .thenApply { packet ->
            packet.data.map {
                RealChannel(
                    bot,
                    it.channelId,
                    it.channelName,
                    it.channelType,
                    bot.getIsland(islandId).get() as RealIsland,
                    it.defaultFlag,
                    it.groupId,
                    it.groupName
                ) as Channel
            }
        }
        .exceptionally { throwable ->
            throwable.printStackTrace()
            emptyList()
        }

    override fun getChannel(channelId: String): CompletableFuture<Channel> = bot.services.channel
        .getChannelInfo(PacketPlayOutChannelId(channelId))
        .asyncExecute()
        .thenApply {
            RealChannel(
                bot,
                it.data.channelId,
                it.data.channelName,
                it.data.channelType,
                bot.getIsland(islandId).get() as RealIsland,
                it.data.defaultFlag,
                it.data.groupId,
                it.data.groupName
            )
        }

    override fun getMembers(): CompletableFuture<List<Member>> = bot.services.island
        .getMemberList(PacketPlayOutMemberList(islandId, 0, 1))
        .asyncExecute()
        .thenApply { packet ->
            packet.data.list.map {
                RealMember(
                    bot,
                    this,
                    it.dodoId,
                    it.nickName,
                    it.personalNickName,
                    it.avatarUrl,
                    it.joinTime,
                    it.sex,
                    it.level,
                    it.isBot,
                    it.onlineDevice,
                    it.onlineStatus
                )
            }
        }

    override fun getMember(dodoId: String): CompletableFuture<Member> = bot.services.island
        .getMemberInfo(PacketPlayOutMemberInfo(dodoId, islandId))
        .asyncExecute()
        .thenApply {
            RealMember(
                bot,
                this,
                it.data.dodoId,
                it.data.nickName,
                it.data.personalNickName,
                it.data.avatarUrl,
                it.data.joinTime,
                it.data.sex,
                it.data.level,
                it.data.isBot,
                it.data.onlineDevice,
                it.data.onlineStatus
            )
        }

    override fun leave() {
        bot.services.bot
            .setBotIslandLeave(PacketPlayOutIslandId(islandId))
            .asyncExecute()
    }
}
