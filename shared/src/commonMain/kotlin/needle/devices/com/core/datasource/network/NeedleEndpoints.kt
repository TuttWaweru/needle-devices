package needle.devices.com.core.datasource.network

import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.http.parameters
import needle.devices.com.models.EventLoginResponse
import needle.devices.com.models.LoginRequest
import needle.devices.com.models.LoginResponse
import needle.devices.com.models.OtpRequest
import needle.devices.com.models.OtpResponse
import needle.devices.com.utils.Constants

suspend fun sampleLogin(eventCode: String): EventLoginResponse {
    return needleClient.submitForm(
        url = "${Constants.SAMPLE_URL}event-login",
        formParameters = parameters {
            append(name = "event_code", eventCode)
        }
    ).body()
}

suspend fun login(request: LoginRequest): LoginResponse {
    return needleClient.submitForm(
        url = "${Constants.BASE_URL}/api/auth/login",
        formParameters = parameters {
            append(name = "username", request.username)
        }
    ).body()
}

suspend fun initGetOtp(request: OtpRequest): OtpResponse {
    return needleClient.submitForm(
        url = "${Constants.BASE_URL}/api/auth/otp",
        formParameters = parameters {
            append(name = "phone_number", request.phoneNumber)
        }
    ).body()
}