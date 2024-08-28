package com.example.filmleruygulamasitasarim.data.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


//fonk databaseden bilgileri çektim
@Dao
interface KullaniciDao {
    //Veritabanına yeni bir kullanıcı ekler.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun kullaniciEkle(kullanicilar: Kullanicilar)

    //Belirli bir kullanici adına sahip kullanıcıyı alır.
    @Query("SELECT * FROM kullanici_arayuz WHERE mail = :mail LIMIT 1")
    fun getKullaniciByMail(mail: String): LiveData<Kullanicilar>

    // dinamik Tüm kullanıcıları alır.
    @Query("SELECT * FROM kullanici_arayuz")
    fun realData(): LiveData<List<Kullanicilar>>
}
