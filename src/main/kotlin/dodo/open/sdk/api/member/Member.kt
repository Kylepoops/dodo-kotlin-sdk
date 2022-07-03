package dodo.open.sdk.api.member

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.internal.island.RealIsland

interface Member {
    val bot: Bot
    val island: RealIsland
    val dodoId: String
    val nickName: String
    val personalNickName: String
    val avatarUrl: String
    val joinTime: String
    val sex: Int
    val level: Int
    val isBot: Int
    val onlineDevice: Int
    val onlineStatus: Int
}