package com.example.protodatastore.datasource

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.protodatastore.Credentials
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object CredentialsSerializer : Serializer<Credentials> {
    override val defaultValue: Credentials = Credentials.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Credentials {
        try {
            return Credentials.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: Credentials,
        output: OutputStream) = t.writeTo(output)
}