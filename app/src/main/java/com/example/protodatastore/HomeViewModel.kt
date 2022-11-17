package com.example.protodatastore


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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
        prepare = { repository.observeLastCredentials().map { HomePartialState.SavedCredentials(it.login, it.password, it.pin) }},
        onEvent = { event ->
            when (event) {
                is HomeEvents.Login -> {
                   // val a = repository.observeLastCredentials().first()
                   // Log.d("TAG", a.pin + a.login + a.password)
                    repository.saveCredentials(event.login, event.password, event.pin).toNoAction()
                }
            }
        })
}
