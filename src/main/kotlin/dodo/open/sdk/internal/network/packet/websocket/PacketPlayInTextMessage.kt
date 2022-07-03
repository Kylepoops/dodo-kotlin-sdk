package dodo.open.sdk.internal.network.packet.websocket


import com.fasterxml.jackson.annotation.JsonProperty

data class PacketPlayInTextMessage(
    val `data`: Data,
    val type: Int
) {
    data class Data(
        val eventBody: EventBody,
        val eventId: String,
        val eventType: String,
        val timestamp: Long
    ) {
        data class EventBody(
            val channelId: String,
            val dodoId: String,
            val islandId: String,
            val member: Member,
            val messageBody: MessageBody,
            val messageId: Long,
            val messageType: Int,
            val personal: Personal,
            val reference: Reference
        ) {
            data class Member(
                val joinTime: String,
                val nickName: String
            )

            data class MessageBody(
                val content: String
            )

            data class Personal(
                val avatarUrl: String,
                val nickName: String,
                val sex: Int
            )

            data class Reference(
                val dodoId: String,
                val messageId: String,
                val nickName: String
            )
        }
    }
}