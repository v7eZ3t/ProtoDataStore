package com.example.protodatastore.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.protodatastore.Credentials
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.math.log

class LoginDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Credentials>
) : LoginDataSource {

    override suspend fun readLastCredentials(): Flow<Credentials> = dataStore.data

    override suspend fun saveCredentials(login: String, password: String, pin: String) {
        dataStore.updateData { currentCredentials ->
            currentCredentials.toBuilder()
                .setLogin(login)
                .setPassword(password)
                .setPin(pin)
                .build()
        }
    }

}


interface LoginDataSource {
    suspend fun readLastCredentials(): Flow<Credentials>
    suspend fun saveCredentials(login: String, password: String, pin: String)
}