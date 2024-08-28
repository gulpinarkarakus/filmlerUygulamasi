package com.example.filmleruygulamasitasarim.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasitasarim.R
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.databinding.FragmentAnasayfaBinding
import com.example.filmleruygulamasitasarim.ui.adapter.FilmlerAdapter
import com.example.filmleruygulamasitasarim.room.FilmlerViewModel

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private val viewModel: FilmlerViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        // Toolbar başlığını ayarla
        binding.toolbarAnasayfa.title = "FİLMLER"

        // RecyclerView için StaggeredGridLayoutManager ayarla
        binding.filmRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Film verilerini hazırla
        val filmlerList = arrayListOf(
            Filmler(1, "django", "Django", 24),
            Filmler(2, "interstellar", "Interstellar", 20),
            Filmler(3, "inception", "Inception", 27),
            Filmler(4, "thehatefuleight", "The Hateful Eight", 14),
            Filmler(5, "thepianist", "The Pianist", 20),
            Filmler(6, "anadoluda", "Anadoluda", 14)
        )

        // RecyclerView adapter'ını ayarla
        val filmlerAdapter = FilmlerAdapter(requireContext(), filmlerList)
        binding.filmRV.adapter = filmlerAdapter

        // Sepet butonuna tıklama işleyicisi ekle
        binding.ibSepet.setOnClickListener {
            findNavController().navigate(R.id.action_anasayfaFragment_to_sepetFragment)
        }

        // FilmlerAdapter içindeki butonlar için işlevleri tanımla
        filmlerAdapter.onSepeteEkle = { film ->
            viewModel.filmleriYukle(film)
        }

        filmlerAdapter.onSepettenCikar = { film ->
            viewModel.sepettenCikar(film)
        }

        return binding.root
    }}
