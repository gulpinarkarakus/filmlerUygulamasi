package com.example.filmleruygulamasitasarim.data.entity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kullanicilar::class], version = 1, exportSchema = false)
abstract class KullaniciData : RoomDatabase() {

    abstract fun kullaniciDao(): KullaniciDao

    companion object {
        @Volatile
        private var INSTANCE: KullaniciData? = null

        fun getData(context: Context): KullaniciData {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KullaniciData::class.java,
                    "kullanici_data" // Veritabanı adı burada doğru şekilde tanımlandı
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
