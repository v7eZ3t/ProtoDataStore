package com.example.protodatastore


import androidx.lifecycle.ViewModel
import com.example.protodatastore.repository.CounterRepository
import com.example.protodatastore.repository.LoginRepository
import com.tomcz.ellipse.Processor
import com.tomcz.ellipse.common.processor
import com.tomcz.ellipse.common.toNoAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject


typealias HomeProcessor = Processor<HomeEvents, HomeState, Any>

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: LoginRepository
) : ViewModel() {

    val processor: HomeProcessor = processor(
        initialState = HomeState(),
        onEvent = { event ->
            when (event) {
                is HomeEvents.Login -> {
                    repository.saveCredentials(event.login, event.password).toNoAction()
                }
                is HomeEvents.RestoreCredentials -> {
                    repository.getLastCredentials().first().toNoAction()
                }
            }
        })
}
