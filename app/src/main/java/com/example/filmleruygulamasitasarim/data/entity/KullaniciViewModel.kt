package com.example.filmleruygulamasitasarim.data.entity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//ViewModel, Repository'den veri alır ve bu verileri UI bileşenlerine sunar.
class KullaniciViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: KullaniciRepository
    //dinamik
    val readData: LiveData<List<Kullanicilar>>

    init {
        val kullaniciDao = KullaniciData.getData(application).kullaniciDao()
        repository = KullaniciRepository(kullaniciDao)

        //Repository'den gelen veriyi gözlemler.
        readData = repository.readData
    }
    // Veritabanına yeni bir kullanıcı ekler.
    fun kullaniciEkle(kullanici: Kullanicilar) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.kullaniciEkle(kullanici)
        }
    }
    // Kullanıcı adına göre kullanıcıyı alır.
    fun getKullaniciByMail(mail: String): LiveData<Kullanicilar> {
        return repository.getKullaniciByMail(mail)
    }
}
