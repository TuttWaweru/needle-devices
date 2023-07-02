package needle.devices.com.androidApp.composeui.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import needle.devices.com.androidApp.models.LoginScreenUiState
import needle.devices.com.core.datasource.network.sampleLogin
import needle.devices.com.settings.NeedleKeyValueStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class LoginScreenViewModel : ViewModel(), KoinComponent {
    private val _uiState: MutableStateFlow<LoginScreenUiState> =
        MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()
    private val needleSettings: NeedleKeyValueStorage by inject()

    fun updatePhoneNumber(value: String) = _uiState.update {
        it.copy(phoneNumber = value)
    }

    suspend private fun isValidPhoneNumber(phoneNumber: String, countryCode: String): Boolean {
        val phoneUtil: PhoneNumberUtil by inject()
        return try {
            val numberProto = phoneUtil.parse(phoneNumber, countryCode)
            phoneUtil.isValidNumber(numberProto)
        } catch (e: Exception) {
            Timber.e(e, e.localizedMessage)
            false
        }
    }

    fun updateLoading(value: Boolean) = _uiState.update {
        it.copy(loading = value)
    }

    fun initEventLogin() = viewModelScope.launch {
        try {
            // Testing
            sampleLogin(eventCode = "demo_event").let { response ->
                Timber.i("** received response: ${response.eventId}")
                response.token?.let { token: String ->
                    needleSettings.token = token
                }
            }
        } catch (e: Exception) {
            Timber.e(e, e.localizedMessage)
        }
    }
}