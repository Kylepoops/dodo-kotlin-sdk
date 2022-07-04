package dodo.open.sdk.api.event

import dodo.open.sdk.api.message.Message

data class ChannelMessageEvent(
    val message: Message
)