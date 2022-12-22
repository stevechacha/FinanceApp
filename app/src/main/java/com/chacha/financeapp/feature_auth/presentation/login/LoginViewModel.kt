package com.chacha.financeapp.feature_auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chacha.financeapp.core.presentation.common.navigation.Graph
import com.chacha.financeapp.core.presentation.common.navigation.HomeNavGraph
import com.chacha.financeapp.core.presentation.common.navigation.RootNavGraph
import com.chacha.financeapp.core.util.Resource
import com.chacha.financeapp.core.util.UiEvents
import com.chacha.financeapp.feature_auth.domain.use_cases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
   private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _logOut = MutableLiveData<Boolean>()
    val logOut : LiveData<Boolean> = _logOut



    private val _usernameState = mutableStateOf(TextFieldState())
    val usernameState: State<TextFieldState> = _usernameState

    fun setUsername(value: String) {
        _usernameState.value = usernameState.value.copy(text = value)
    }

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState
    fun setPassword(value: String) {
        _passwordState.value = _passwordState.value.copy(text = value)
    }

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword
    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }


    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private val _eventFlow = MutableSharedFlow<LoginUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()


    /*private val _loginUIState = MutableLiveData<LoginUIState>(null)
    val loginUIState: LiveData<LoginUIState> = _loginUIState*/

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            _loginState.value = loginState.value.copy(isLoading = true)

            val loginResponse = loginUseCase(
                email = usernameState.value.text,
                password = passwordState.value.text,
                phoneNumber = usernameState.value.text
            )
            _loginState.value = loginState.value.copy(isLoading = false)

            if (loginResponse.usernameError != null){
                _usernameState.value = usernameState.value.copy(error = loginResponse.usernameError)
            }

            if (loginResponse.passwordError != null){
                _passwordState.value = passwordState.value.copy(error = loginResponse.passwordError)
            }

            when(loginResponse.result){
                is Resource.Success ->{
                    _eventFlow.emit(
                        LoginUiEvents.NavigateEvent(route = Graph.HOME)
                    )
                }
                is Resource.Error ->{
                    _eventFlow.emit(
                        LoginUiEvents.SnackBarEvent(
                            loginResponse.result.message?: "Unknown error occurred"
                        )
                    )
                }
                else ->{}
            }
        }

    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            logout()
        }
    }

}

sealed class LoginUiEvents {
    data class SnackBarEvent(val message: String) : LoginUiEvents()
    data class NavigateEvent(val route: String) : LoginUiEvents()
}

sealed class LoginUIState {
    object Loading : LoginUIState()
    object Success : LoginUIState()
    data class Error(val message: String) : LoginUIState()
}


/*fun login(email: String, password: String,phoneNumber: String) {
    viewModelScope.launch(Dispatchers.IO) {

        _loginUIState.postValue(LoginUIState.Loading)
        val result = repository.loginUser(Login(email, password,phoneNumber))

        if (result is Resource.Success) {
            _loginUIState.postValue(result.message?.let { LoginUIState.Success(it) })
        } else if (result is Resource.Error) {
            _loginUIState.postValue(result.message?.let { LoginUIState.Error(it) })
        }

    }

}*/


