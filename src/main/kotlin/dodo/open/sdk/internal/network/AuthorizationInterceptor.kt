package dodo.open.sdk.internal.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(auth: dodo.open.sdk.internal.network.Authorization) : Interceptor {
    private val authorization = "Bot ${auth.clientId}.${auth.token}"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", authorization)
            .build()

        return chain.proceed(request)
    }
}
