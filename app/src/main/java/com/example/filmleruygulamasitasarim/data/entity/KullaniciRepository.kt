package com.example.filmleruygulamasitasarim.data.entity

import androidx.lifecycle.LiveData

class KullaniciRepository(private val kullaniciDao: KullaniciDao) {

    // Veritabanındaki tüm kullanıcıları okuma
    val readData: LiveData<List<Kullanicilar>> = kullaniciDao.realData()

    // Kullanıcıyı ekleme işlevi
    suspend fun kullaniciEkle(kullanicilar: Kullanicilar) {
        kullaniciDao.kullaniciEkle(kullanicilar)
    }

    // Belirli bir email adresine göre kullanıcıyı alma işlevi
    fun getKullaniciByMail(mail: String): LiveData<Kullanicilar> {
        return kullaniciDao.getKullaniciByMail(mail)
    }
}
