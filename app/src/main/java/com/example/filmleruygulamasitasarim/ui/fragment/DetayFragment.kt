package com.example.filmleruygulamasitasarim.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmleruygulamasitasarim.R
import com.example.filmleruygulamasitasarim.databinding.FragmentDetayBinding // Import the binding class

class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle: DetayFragmentArgs by navArgs()
        val film=bundle.film
        binding.toolbarDetay.title=film.ad
        binding.textViewDetay.text="${film.fiyat}₺"

//        binding.imageViewDetay.setImageResource(
//            resources.getIdentifier(film.resim,"drawable",requireContext()packageName))

        val imageResource = resources.getIdentifier(film.resim, "drawable", requireContext().packageName)
        if (imageResource != 0) { // Kaynak bulunduysa
            binding.imageViewDetay.setImageResource(imageResource)
        }


        return binding.root
    }
}
