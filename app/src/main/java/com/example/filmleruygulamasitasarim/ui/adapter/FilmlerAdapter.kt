package com.example.filmleruygulamasitasarim.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.databinding.CardTasarimBinding
import com.example.filmleruygulamasitasarim.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar


class FilmlerAdapter(var mContext:Context,var filmlerList:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>()
{
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
    return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(
        holder: CardTasarimTutucu,
        position: Int,
    ) {
       val film=filmlerList.get(position)

        val t=holder.tasarim
      t.imageViewFilm.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))
        t.textViewFiyat.text="${film.fiyat }₺"

        t.cardviewDetay.setOnClickListener{
val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(film=film)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.buttonSepet.setOnClickListener{
           Snackbar.make(it,"${film.ad} sepete eklendi",Snackbar.LENGTH_SHORT).show()
       }

    }

    override fun getItemCount(): Int {
        return filmlerList.size
    }}



