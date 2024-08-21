package com.example.filmleruygulamasitasarim.room

import androidx.lifecycle.LiveData
import com.example.filmleruygulamasitasarim.data.entity.Filmler

class FilmlerRepository(private val filmlerDao: FilmlerDao) {

    // Veritabanındaki tüm filmleri okuma
    val readData: LiveData<List<Filmler>> = filmlerDao.readData()

    // Filmleri veritabanına ekleme
    fun filmleriYukle(filmler: Filmler) {
        filmlerDao.filmleriYukle(filmler)
    }

    // Sepetten film çıkarma işlemi
    fun sepettenCikar(filmler: Filmler) {
        filmlerDao.sepettenCikar(filmler)
    }
}
