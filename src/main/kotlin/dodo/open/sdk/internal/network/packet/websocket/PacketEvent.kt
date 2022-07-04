package dodo.open.sdk.internal.network.packet.websocket

data class PacketEvent<T : EventBody>(
    val type: Int,
    val data: PacketEventData<T>
)
