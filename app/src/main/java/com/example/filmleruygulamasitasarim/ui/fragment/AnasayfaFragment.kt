package com.example.filmleruygulamasitasarim.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasitasarim.R
import com.example.filmleruygulamasitasarim.data.entity.Filmler
import com.example.filmleruygulamasitasarim.databinding.FragmentAnasayfaBinding // Import the binding class
import com.example.filmleruygulamasitasarim.ui.adapter.FilmlerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        //TOOLBAR BASLİK KAÇ TANE KART YANYANA OLUCAK VE YÖNÜ
        binding.toolbarAnasayfa.title="FİLMLER"
        //sepete eklemedim
        binding.filmRV.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//adapter için liste hazırladım (context ve list)
        val filmlerList = ArrayList<Filmler>()
        val f1=Filmler(1,"django","Django",24)
        val f2=Filmler(2,"interstellar","Interstellar",20)
        val f3=Filmler(3,"inception","Inception",27)
        val f4=Filmler(4,"thehatefuleight","The Hateful Eight",14)
        val f5=Filmler(5,"thepianist","The Pianiat",20)
        val f6=Filmler(6,"anadoluda","Anadoluda",14)
        //filmler eklendi

        filmlerList.add(f1)
        filmlerList.add(f2)
        filmlerList.add(f3)
        filmlerList.add(f4)
        filmlerList.add(f5)
        filmlerList.add(f6)
//RecyclerView aktardım
val filmlerAdapter=FilmlerAdapter(requireContext(),filmlerList)
        binding.filmRV.adapter=filmlerAdapter
            return binding.root


}}
