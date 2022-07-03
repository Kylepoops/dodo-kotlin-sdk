package dodo.open.sdk.internal.member

import dodo.open.sdk.api.member.Member
import dodo.open.sdk.internal.bot.RealBot
import dodo.open.sdk.internal.island.RealIsland

data class RealMember(
    override val bot: RealBot,
    override val island: RealIsland,
    override val dodoId: String,
    override val nickName: String,
    override val personalNickName: String,
    override val avatarUrl: String,
    override val joinTime: String,
    override val sex: Int,
    override val level: Int,
    override val isBot: Int,
    override val onlineDevice: Int,
    override val onlineStatus: Int
) : Member
