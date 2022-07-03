package dodo.open.sdk.internal.network.service

import dodo.open.sdk.internal.network.RetrofitManager

class Services(retrofitManager: RetrofitManager) {
    val bot = retrofitManager.createService<BotService>()
    val island = retrofitManager.createService<IslandService>()
    val channel = retrofitManager.createService<ChannelService>()
    val websocket = retrofitManager.createService<WebSocketService>()
}
