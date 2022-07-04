import java.util.concurrent.CompletableFuture

fun <T, U> CompletableFuture<List<T>>.thenApplyEach(block: (T) -> U): CompletableFuture<List<U>> =
    thenApply { it.map(block) }

fun <T> CompletableFuture<List<T>>.thenAcceptEach(block: (T) -> Unit): CompletableFuture<Void> =
    thenAccept { it.forEach(block) }
