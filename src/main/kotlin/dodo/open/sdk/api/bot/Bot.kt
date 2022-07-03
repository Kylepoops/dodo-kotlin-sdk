package dodo.open.sdk.api.bot

import dodo.open.sdk.api.island.Island
import java.util.concurrent.CompletableFuture

interface Bot {
    fun getBotInfo(): CompletableFuture<BotInfo>
    fun getIslands(): CompletableFuture<List<Island>>
    fun getIsland(islandId: String): CompletableFuture<Island>
}
