package dodo.open.sdk.api.bot

import dodo.open.sdk.api.island.Island
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.CompletableFuture

interface Bot {
    val globalEventBus: EventBus
    fun getBotInfo(): CompletableFuture<BotInfo>
    fun getIslands(): CompletableFuture<List<Island>>
    fun getIsland(islandId: String): CompletableFuture<Island>
}
