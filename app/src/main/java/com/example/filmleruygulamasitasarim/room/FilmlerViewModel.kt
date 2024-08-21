package com.example.filmleruygulamasitasarim.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmlerViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository: FilmlerRepository
    val readData: LiveData<List<Filmler>>

    init {
        val filmlerDao = Veritabani.getData(application).filmlerDao()
        repository = FilmlerRepository(filmlerDao)
        readData = repository.readData
    }

    fun filmleriYukle(filmler: Filmler) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.filmleriYukle(filmler)
        }
    }

    fun sepettenCikar(filmler: Filmler) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.sepettenCikar(filmler)
        }
    }
}
