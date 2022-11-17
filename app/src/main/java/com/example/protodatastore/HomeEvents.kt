package com.example.protodatastore

sealed class HomeEvents {
    data class Login(val login: String, val password: String, val pin: String): HomeEvents()
}