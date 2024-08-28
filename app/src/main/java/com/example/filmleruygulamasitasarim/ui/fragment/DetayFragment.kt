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
        //bundle kartın içindeki bilgiyi dataya aktarır
        val film=bundle.film
        //toolbarda film adını gösterir
        binding.toolbarDetay.title=film.ad
        // Film fiyatını TextView'de gösterir
        binding.textViewDetay.text="${film.fiyat}₺"

        // Film resmini drawable kaynaklarından yükler
        val imageResource = resources.getIdentifier(film.resim, "drawable", requireContext().packageName)
        if (imageResource != 0) { // Kaynak bulunduysa
            binding.imageViewDetay.setImageResource(imageResource)
        }


        return binding.root
    }
}
