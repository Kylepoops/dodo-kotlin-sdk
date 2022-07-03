package dodo.open.sdk.internal.network

import dodo.open.sdk.internal.network.annontation.DodoRequestPacket
import dodo.open.sdk.internal.util.jsonMapper
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class PacketConverterFactory : Converter.Factory() {
    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        if (!getRawType(type).isAnnotationPresent(DodoRequestPacket::class.java)) {
            return null
        }

        return Converter<Any, RequestBody> {
            RequestBody.create(MediaType.parse("application/json"), jsonMapper.writeValueAsString(it))
        }
    }
}