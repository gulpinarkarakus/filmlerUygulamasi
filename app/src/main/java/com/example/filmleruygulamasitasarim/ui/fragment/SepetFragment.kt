package com.example.filmleruygulamasitasarim.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)


        initViewModel()

        // RecyclerView
        binding.toolbarSepet.title = "Sepet"
        binding.sepetRV.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)


        sepetAdapter = SepetAdapter { filmler ->
            viewModel.sepettenCikar(filmler)
        }
        binding.sepetRV.adapter = sepetAdapter

        //data aktarma
        viewModel.readData.observe(viewLifecycleOwner, { filmlerList ->
            Log.d("pınar", filmlerList.toString())
            sepetAdapter.submitList(filmlerList)
        })

        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(FilmlerViewModel::class.java)
    }
}

