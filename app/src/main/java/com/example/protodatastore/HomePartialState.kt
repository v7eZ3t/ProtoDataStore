package com.example.protodatastore

import com.tomcz.ellipse.PartialState
import kotlin.math.log

sealed interface HomePartialState: PartialState<HomeState> {


    class SavedCredentials(private val login: String, private val password: String, private val pin: String) : HomePartialState {
        override fun reduce(oldState: HomeState): HomeState {
            return oldState.copy(login = login, password = password, pin = pin)
        }
    }



}