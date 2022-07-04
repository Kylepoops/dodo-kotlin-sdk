package dodo.open.sdk.internal.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import dodo.open.sdk.internal.network.packet.common.MessageBody
import dodo.open.sdk.internal.network.packet.common.MessageBodyImage
import dodo.open.sdk.internal.network.packet.common.MessageBodyText

class MessageBodyDeserializer : JsonDeserializer<MessageBody>() {
    override fun deserialize(parser: JsonParser, ctx: DeserializationContext): MessageBody? {
        val node = parser.readValueAsTree<JsonNode>()

        return when {
            node.has("content") -> MessageBodyText(node.get("content").asText())
            node.has("width") -> MessageBodyImage(
                node.get("url").asText(),
                node.get("width").asInt(),
                node.get("height").asInt(),
                node.get("isOriginal").asInt()
            )
            else -> null
        }
    }
}
