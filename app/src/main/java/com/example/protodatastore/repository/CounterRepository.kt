package com.example.protodatastore.repository

import com.example.protodatastore.datasource.CounterDataSourceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CounterRepository @Inject constructor(
    private val counterDataSource: CounterDataSourceImpl
) {
    suspend fun observeLastNumber(): Flow<Int> {
        return counterDataSource.readLastNumber()
    }

    suspend fun saveNumber(number: Int) {
        counterDataSource.saveNumber(number)
    }

}
