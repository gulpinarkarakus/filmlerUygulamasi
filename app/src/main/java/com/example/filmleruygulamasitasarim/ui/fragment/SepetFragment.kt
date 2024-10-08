package com.example.filmleruygulamasitasarim.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasitasarim.databinding.FragmentSepetBinding
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.ui.adapter.SepetAdapter
import com.example.filmleruygulamasitasarim.room.FilmlerViewModel

class SepetFragment : Fragment() {

    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: FilmlerViewModel
    private lateinit var sepetAdapter: SepetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)

        initViewModel()

        // RecyclerView ayarları
        binding.toolbarSepet.title = "Sepet"
        binding.sepetRV.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        // SepetAdapter ve sepeten çıkarma
        sepetAdapter = SepetAdapter { filmler ->
            viewModel.sepettenCikar(filmler)
        }
        // RecyclerView'a SepetAdapter'ı atar
        binding.sepetRV.adapter = sepetAdapter

        // Data aktarımı dinamik
        viewModel.readData.observe(viewLifecycleOwner, { filmlerList ->
            sepetAdapter.submitList(filmlerList)
        })

        return binding.root
    }
//verilerin korunmasını sağlar.
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(FilmlerViewModel::class.java)
    }
}
