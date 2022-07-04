package dodo.open.sdk.internal.network.packet.websocket

data class PacketEventData<T : EventBody>(
    val eventId: String,
    val eventType: String,
    val eventBody: T,
    val timestamp: Long
)
