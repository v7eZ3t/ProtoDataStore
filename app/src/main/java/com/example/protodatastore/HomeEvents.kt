package com.example.protodatastore

sealed class HomeEvents {
    data class Login(val login: String, val password: String): HomeEvents()
    data class RestoreCredentials(val login: String, val password: String): HomeEvents()
}