package com.example.filmleruygulamasitasarim.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


//kullanıcağım parametreler
@Entity(tableName="Filmler")
data class Filmler(
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="id") @NotNull  var id:Int,
    @ColumnInfo(name="resim") @NotNull var resim:String,
    @ColumnInfo(name="ad") @NotNull var ad:String,
    @ColumnInfo(name="fiyat") @NotNull var fiyat:Int): Serializable {
}