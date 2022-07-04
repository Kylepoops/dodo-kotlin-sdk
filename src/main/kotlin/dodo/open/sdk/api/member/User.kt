package dodo.open.sdk.api.member

import dodo.open.sdk.api.bot.Bot

interface User {
    val bot: Bot
    val dodoId: String
    val personalNickName: String
    val avatarUrl: String
    val sex: Int
}