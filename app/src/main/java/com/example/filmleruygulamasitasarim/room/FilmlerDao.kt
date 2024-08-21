package com.example.filmleruygulamasitasarim.room

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.filmleruygulamasitasarim.data.entity.Filmler

@Dao
interface FilmlerDao {

    // Tüm filmleri veritabanından okuma
    @Query("SELECT * FROM filmler")
    fun readData(): LiveData<List<Filmler>>

    // Filmleri veritabanına ekleme veya güncelleme
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun filmleriYukle(film: Filmler)

    // Sepetten film çıkarma
    @Delete
     fun sepettenCikar(film: Filmler)
}
