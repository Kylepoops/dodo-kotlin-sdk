package dodo.open.sdk.internal.network.exception

class DodoException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}