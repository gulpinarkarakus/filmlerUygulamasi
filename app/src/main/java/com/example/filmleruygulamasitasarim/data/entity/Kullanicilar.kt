package com.example.filmleruygulamasitasarim.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
// datalar dinamik bilgi
@Entity(tableName = "kullanici_arayuz")
data class Kullanicilar (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val mail: String,
    val parola: String
)
