package needle.devices.com.core.datasource.network

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.submitForm
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import needle.devices.com.models.EventLoginResponse
import needle.devices.com.utils.Constants.SAMPLE_URL

val needleClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    install(Logging) {
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                Napier.v(tag = "NeedleHttpClient", message = message)
            }
        }
    }
}

suspend fun sampleLogin(eventCode: String): EventLoginResponse {
    return needleClient.submitForm(
        url = "${SAMPLE_URL}event-login",
        formParameters = parameters {
            append(name = "event_code", eventCode)
        }
    ).body()
}