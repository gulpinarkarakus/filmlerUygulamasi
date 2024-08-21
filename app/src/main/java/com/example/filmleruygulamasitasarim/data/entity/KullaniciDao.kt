package com.example.filmleruygulamasitasarim.data.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KullaniciDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun kullaniciEkle(kullanicilar: Kullanicilar)

    @Query("SELECT * FROM kullanici_arayuz WHERE mail = :mail LIMIT 1")
    fun getKullaniciByMail(mail: String): LiveData<Kullanicilar>

    @Query("SELECT * FROM kullanici_arayuz")
    fun realData(): LiveData<List<Kullanicilar>>
}
