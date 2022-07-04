package dodo.open.sdk.internal.network.packet.clientbound

data class ClientboundPacket<T>(
    val status: Int,
    val message: String,
    val data: T
)
