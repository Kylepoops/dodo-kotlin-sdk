package dodo.open.sdk.internal.network

import dodo.open.sdk.internal.util.jsonMapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitManager(auth: Authorization) {
    private val retrofit: Retrofit

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor(auth))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(jsonMapper))
            .addConverterFactory(PacketConverterFactory())
            .build()
    }

    @Deprecated(
        "use createService<T>() instead",
        ReplaceWith("createService<T>()")
    )
    fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> createService(): T = createService(T::class.java)

    companion object {
        private const val BASE_URL = "https://botopen.imdodo.com/api/v1/"
    }
}
