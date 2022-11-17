package com.example.protodatastore

import com.tomcz.ellipse.PartialState
import kotlin.math.log

sealed interface HomePartialState: PartialState<HomeState> {

//    class ChangeNumber(private val num: Int) : HomePartialState {
//        override fun reduce(oldState: HomeState): HomeState {
//            return oldState.copy(currNumber = num)
//        }
//    }

    class ChangeSavedCredentials(private val login: String, private val password: String) : HomePartialState {
        override fun reduce(oldState: HomeState): HomeState {
            return oldState.copy(login = login, password = password)
        }
    }



}