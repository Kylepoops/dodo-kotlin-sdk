package dodo.open.sdk.api.message

interface ImageMessage : Message {
    val url: String
    val width: Int
    val height: Int
    val isOriginal: Boolean
}
