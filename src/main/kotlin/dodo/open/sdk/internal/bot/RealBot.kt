package dodo.open.sdk.internal.bot

import dodo.open.sdk.api.bot.Bot
import dodo.open.sdk.api.bot.BotInfo
import dodo.open.sdk.api.island.Island
import dodo.open.sdk.internal.island.RealIsland
import dodo.open.sdk.internal.network.Authorization
import dodo.open.sdk.internal.network.RetrofitManager
import dodo.open.sdk.internal.network.packet.serverbound.ServerboundIslandIdPacket
import dodo.open.sdk.internal.network.service.Services
import dodo.open.sdk.internal.network.websocket.WebSocketConnection
import dodo.open.sdk.internal.util.asyncExecute
import java.util.concurrent.CompletableFuture

class RealBot(auth: Authorization) : Bot {
    internal val services = Services(RetrofitManager(auth))
    private lateinit var connection: WebSocketConnection

    init {
        services.websocket.getWebSocketConnection()
            .asyncExecute()
            .thenApply { it.data.endpoint }
            .thenAccept { connection = WebSocketConnection(this, it) }
    }

    override fun getBotInfo() = services.bot.getBotInfo().asyncExecute().thenApply {
        BotInfo(
            it.data.avatarUrl,
            it.data.clientId,
            it.data.dodoId,
            it.data.nickName
        )
    }

    override fun getIslands(): CompletableFuture<List<Island>> = services.island
        .getIslandList()
        .asyncExecute()
        .thenApply { packet ->
            packet.data
                .map { getIsland(it.islandId) }
                .map { it.get() }
        }

    override fun getIsland(islandId: String): CompletableFuture<Island> = services.island
        .getIslandInfo(ServerboundIslandIdPacket(islandId))
        .asyncExecute()
        .thenApply {
            RealIsland(
                this,
                it.data.coverUrl,
                it.data.defaultChannelId,
                it.data.islandId,
                it.data.islandName,
                it.data.memberCount,
                it.data.onlineMemberCount,
                it.data.systemChannelId,
                it.data.systemChannelId
            )
        }
}
