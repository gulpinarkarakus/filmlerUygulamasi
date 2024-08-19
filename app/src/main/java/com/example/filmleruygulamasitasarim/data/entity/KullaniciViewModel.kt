package com.example.filmleruygulamasitasarim.data.entity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KullaniciViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: KullaniciRepository
    val readData: LiveData<List<Kullanicilar>>

    init {
        val kullaniciDao = KullaniciData.getData(application).kullaniciDao()
        repository = KullaniciRepository(kullaniciDao)
        readData = repository.readData
    }

    fun kullaniciEkle(kullanici: Kullanicilar) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.kullaniciEkle(kullanici)
        }
    }

    fun getKullaniciByMail(mail: String): LiveData<Kullanicilar> {
        return repository.getKullaniciByMail(mail)
    }
}
