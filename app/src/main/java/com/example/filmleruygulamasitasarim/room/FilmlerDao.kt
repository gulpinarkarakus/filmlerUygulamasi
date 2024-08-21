package com.example.filmleruygulamasitasarim.room

import androidx.room.Dao
import androidx.room.Query
import com.example.filmleruygulamasitasarim.data.entity.Filmler


@Dao
interface FilmlerDao {
    @Query("SELECT * FROM filmler")
  fun filmleriYukle(): List<Filmler>
}