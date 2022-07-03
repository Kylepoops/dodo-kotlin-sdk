package dodo.open.sdk.api.island

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.member.Member
import java.util.concurrent.CompletableFuture

interface Island {
    val bot: Bot
    val coverUrl: String
    val defaultChannelId: String
    val islandId: String
    val islandName: String
    val memberCount: Int
    val onlineMemberCount: Int
    val systemChannelId: String
    val description: String

    fun getChannels(): CompletableFuture<List<Channel>>
    fun getChannel(channelId: String): CompletableFuture<Channel>
    fun getMembers(): CompletableFuture<List<Member>>
    fun getMember(dodoId: String): CompletableFuture<Member>

    fun leave()
}
