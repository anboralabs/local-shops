package co.anbora.labs.localstores.data.remote.api

import co.anbora.labs.localstores.data.local.AssetFileReader
import okhttp3.*

const val SUCCESS_CODE = 200

class FakeResponseInterceptor(private val fileReader: AssetFileReader): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val fileEndpoint = chain.request().url().uri().path.substring(1)

        val responseString = fileReader.read(fileEndpoint)

        return Response.Builder()
            .request(chain.request())
            .code(SUCCESS_CODE)
            .protocol(Protocol.HTTP_1_1)
            .message(responseString)
            .body(
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    responseString.toByteArray()))
            .addHeader("content-type", "application/json")
            .build()
    }
}