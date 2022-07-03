package dodo.open.sdk.internal.network.packet

data class PacketPlayInMemberList(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val list: List<MemberData>,
        val maxId: Int
    ) {
        data class MemberData(
            val avatarUrl: String,
            val dodoId: String,
            val isBot: Int,
            val joinTime: String,
            val level: Int,
            val nickName: String,
            val onlineDevice: Int,
            val onlineStatus: Int,
            val personalNickName: String,
            val sex: Int
        )
    }
}