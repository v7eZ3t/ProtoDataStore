package com.example.protodatastore.repository

import com.example.protodatastore.datasource.CounterDataSourceImpl
import com.example.protodatastore.datasource.LoginDataSourceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val loginDataSource: LoginDataSourceImpl
) {
    suspend fun getLastCredentials(): Flow<String> {
        return loginDataSource.readLastCredentials()
    }

    suspend fun saveCredentials(login: String, password: String) {
        loginDataSource.saveCredentials(login, password)
    }

}