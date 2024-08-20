package com.example.filmleruygulamasitasarim.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.databinding.SepetTasarimBinding


class SepetAdapter(var mContext:Context,var filmlerList:List<Filmler>)
    :RecyclerView.Adapter<SepetAdapter.SepetTasarimTutucu>(){

    inner class SepetTasarimTutucu(var tasarim: SepetTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SepetAdapter.SepetTasarimTutucu {
        //chatten aldım
        val binding = SepetTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SepetTasarimTutucu(binding)
    }

    override fun onBindViewHolder(
        holder: SepetTasarimTutucu,
        position: Int) {
        val film=filmlerList.get(position)
        val temp=holder.tasarim
        temp.imageViewFilmSepet.setImageResource(mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))
        temp.textViewFiyatSepet.text="${film.fiyat }₺"


    }




    override fun getItemCount(): Int {
        return filmlerList.size
    }
    }
//ınıtle aktar



