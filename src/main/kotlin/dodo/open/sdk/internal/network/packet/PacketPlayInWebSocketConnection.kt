package dodo.open.sdk.internal.network.packet

data class PacketPlayInWebSocketConnection(
    val data: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val endpoint: String
    )
}
