package com.example.filmleruygulamasitasarim.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


//veri tutma
//her bir kullanıcı verisinin nasıl saklanacağını tanımlar.
@Entity(tableName = "kullanici_arayuz")
data class Kullanicilar (
    //0-1-2
    @PrimaryKey(autoGenerate=true)
    val id: Int,
    val mail: String,
    val parola: String
)
