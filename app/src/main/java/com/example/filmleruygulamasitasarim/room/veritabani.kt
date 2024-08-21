package com.example.filmleruygulamasitasarim.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.room.FilmlerDao


@Database(entities = [Filmler::class], version = 1)
abstract class veritabani : RoomDatabase() {

    abstract fun getFilmlerDao(): FilmlerDao
}
