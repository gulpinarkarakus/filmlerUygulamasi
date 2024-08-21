package com.example.filmleruygulamasitasarim.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmleruygulamasitasarim.data.entity.Filmler

@Database(entities = [Filmler::class], version = 1, exportSchema = false)
abstract class Veritabani : RoomDatabase() {

    abstract fun filmlerDao(): FilmlerDao

    companion object {
        @Volatile
        private var INSTANCE: Veritabani? = null

        fun getData(context: Context): Veritabani {
            // Eğer INSTANCE null değilse mevcut örneği döndür, değilse yeni bir tane oluştur
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Veritabani::class.java,
                    "sepet.sqlite" // Veritabanı adı
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


