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

class FilmlerAdapter(
    private val mContext: Context,
    private val filmlerList: List<Filmler>
) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

// Bu fonksiyonlar, sepete ekleme ve sepette çıkarma işlemlerini yönetir
    var onSepeteEkle: ((Filmler) -> Unit)? = null
    var onSepettenCikar: ((Filmler) -> Unit)? = null

    inner class CardTasarimTutucu(val tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    @SuppressLint("ResourceType")
    //uı elementleri koda aktardım binding
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerList[position]
        val t = holder.tasarim
        //detay frgamnet
        // Film resmini ilgili drawable kaynağından yükler
        t.imageViewFilm.setImageResource(mContext.resources.getIdentifier(film.resim, "drawable", mContext.packageName))
        // Film fiyatını TextView'e atar
        t.textViewFiyat.text = "${film.fiyat}₺"
        // CardView'e tıklandığında, film detaylarına geçiş yapar
        t.cardviewDetay.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        //sepet fragment
        // Sepet butonuna tıklandığında, film sepete eklenir
        t.buttonSepet.setOnClickListener {
            onSepeteEkle?.invoke(film)
            Snackbar.make(it, "${film.ad} sepete eklendi", Snackbar.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {
        // Liste boyutunu döner.
        return filmlerList.size
    }
}




