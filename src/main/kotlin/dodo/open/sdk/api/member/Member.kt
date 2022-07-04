package dodo.open.sdk.api.member

import dodo.open.sdk.internal.island.RealIsland

interface Member : User {
    val island: RealIsland
    val joinTime: String
    val nickName: String
    val level: Int
    val isBot: Int
    val onlineDevice: Int
    val onlineStatus: Int
}
