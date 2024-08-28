package com.example.filmleruygulamasitasarim.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.databinding.SepetTasarimBinding

class SepetAdapter(private val onRemoveClick: (Filmler) -> Unit) :
    ListAdapter<Filmler, SepetAdapter.FilmlerViewHolder>(FilmlerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmlerViewHolder {
        val binding = SepetTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmlerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmlerViewHolder, position: Int) {
        val filmler = getItem(position)
        holder.bind(filmler)

        // Sepet butonuna tıklandığında filmleri çıkarır
        holder.binding.buttonSepet.setOnClickListener {
            onRemoveClick(filmler)
        }
    }

    class FilmlerViewHolder(val binding: SepetTasarimBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(filmler: Filmler) {
            binding.filmler = filmler

            // Resmi drawable'dan yükler
            val context = binding.imageViewFilmSepet.context
            val resimId = context.resources.getIdentifier(filmler.resim, "drawable", context.packageName)
            binding.imageViewFilmSepet.setImageResource(resimId)

            // Fiyatı gösterir
            binding.textViewFiyatSepet.text = "${filmler.fiyat} TL"
           // verilerin kullanıcı arayüzünde (UI) hemen güncellenmesini sağlar.
            binding.executePendingBindings()
        }
    }
}

class FilmlerDiffCallback : DiffUtil.ItemCallback<Filmler>() {
    // Eski ve yeni film öğelerinin aynı olup olmadığını kontrol eder
    override fun areItemsTheSame(oldItem: Filmler, newItem: Filmler): Boolean {
        return oldItem.id == newItem.id
    }
    // Eski ve yeni film öğelerinin içeriklerinin aynı olup olmadığını kontrol eder
    override fun areContentsTheSame(oldItem: Filmler, newItem: Filmler): Boolean {
        return oldItem == newItem
    }
}
