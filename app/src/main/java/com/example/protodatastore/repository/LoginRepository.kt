package com.example.protodatastore.repository

import com.example.protodatastore.Credentials
import com.example.protodatastore.datasource.CounterDataSourceImpl
import com.example.protodatastore.datasource.LoginDataSourceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val loginDataSource: LoginDataSourceImpl
) {
    suspend fun observeLastCredentials(): Flow<Credentials> {
        return loginDataSource.readLastCredentials()
    }

    suspend fun saveCredentials(login: String, password: String, age: String) {
        loginDataSource.saveCredentials(login, password, age)
    }

}