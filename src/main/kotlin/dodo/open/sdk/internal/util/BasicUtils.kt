package dodo.open.sdk.internal.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jsonMapper
import dodo.open.sdk.internal.jackson.MessageBodyDeserializer
import dodo.open.sdk.internal.network.packet.common.MessageBody
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.CompletableFuture

val jsonMapper = jsonMapper {
    val kotlinModule = KotlinModule.Builder()
        .configure(KotlinFeature.NullToEmptyCollection, true)
        .configure(KotlinFeature.NullToEmptyMap, true)
        .configure(KotlinFeature.NullIsSameAsDefault, true)
        .configure(KotlinFeature.SingletonSupport, false)
        .configure(KotlinFeature.StrictNullChecks, false)
        .build()

    val simpleModule = SimpleModule()
        .addDeserializer(MessageBody::class.java, MessageBodyDeserializer())

    addModule(kotlinModule)
    addModule(simpleModule)
}

fun <T> Call<T>.asyncExecute(): CompletableFuture<T> {
    val future = CompletableFuture<T>()
    enqueue(object : retrofit2.Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            future.complete(response.body())
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            t.printStackTrace()
            future.completeExceptionally(t)
        }
    })
    return future
}

inline fun <reified T> referType() = object : TypeReference<T>() {}
