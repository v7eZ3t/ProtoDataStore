package com.example.protodatastore.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LoginDataSource {

    companion object PreferencesKeys {
        val CREDENTIALS = stringPreferencesKey("credentials")
    }


     suspend fun readLastCredentials2(): Flow<String> {
        //TODO("Not yet implemented")
        return flow {  }
    }


     suspend fun saveCredentials2(login: String, password: String) {
        //TODO("Not yet implemented")
    }

    override suspend fun readLastCredentials(): Flow<String> = dataStore.data.map {
        it[CREDENTIALS] ?: ""
    }

    override suspend fun saveCredentials(login: String, password: String) {
        dataStore.edit {
            it[CREDENTIALS] = login
        }
    }

}


interface LoginDataSource {
    suspend fun readLastCredentials(): Flow<String>
    suspend fun saveCredentials(login: String, password: String)
}