package com.example.filmleruygulamasitasarim.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
//entityler ve datalar dinamik bilgi çekiceğimiz zaman kullandığımız yapılar
@Entity(tableName = "kullanici_arayuz")
data class Kullanicilar (
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val mail: String,
    val parola: String
)
