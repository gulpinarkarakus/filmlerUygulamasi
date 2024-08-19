package com.example.filmleruygulamasitasarim.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.filmleruygulamasitasarim.data.entity.KullaniciViewModel
import com.example.filmleruygulamasitasarim.data.entity.Kullanicilar
import com.example.filmleruygulamasitasarim.databinding.FragmentKayitGirisBinding
import com.google.android.material.snackbar.Snackbar

class KayitGirisFragment : Fragment() {

    private lateinit var binding: FragmentKayitGirisBinding
    private lateinit var mKullaniciViewModel: KullaniciViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitGirisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kayitGiris2.setOnClickListener {
            findNavController().navigate(com.example.filmleruygulamasitasarim.R.id.action_kayitGirisFragment_to_girisFragment)
        }

        // ViewModel'i başlatmak için ViewModelProvider kullanın
        mKullaniciViewModel = ViewModelProvider(this).get(KullaniciViewModel::class.java)

        binding.kayitGiris.setOnClickListener {
            insertDataToDataBase()
        }
    }

    // Veritabanına veri ekleme
    private fun insertDataToDataBase() {
        val mail = binding.kayitMail.text.toString()
        val parola = binding.kayitParola.text.toString()
        val id = 0 // Sabit bir ID kullanıyoruz, eğer farklı bir ID kullanacaksanız bu kısmı değiştirin

        if (kontrol(mail, parola)) {
            val kullanici = Kullanicilar(0,mail, parola) // ID'nin manuel verilmesine gerek yok
            mKullaniciViewModel.kullaniciEkle(kullanici)
            Toast.makeText(requireContext(), "Üyeliğiniz başarıyla oluşturuldu", Toast.LENGTH_SHORT).show()
            findNavController().navigate(com.example.filmleruygulamasitasarim.R.id.action_kayitGirisFragment_to_girisFragment)
        } else {
            // Hata mesajı gösterme
            Snackbar.make(binding.root, "Email veya şifre boş olamaz!", Snackbar.LENGTH_LONG).show()

            // Toolbar başlığını hata mesajı olarak değiştirme
            (activity as? AppCompatActivity)?.supportActionBar?.title = "Hata: Email veya şifre boş"
        }
    }

    // Boş alan kontrolü
    private fun kontrol(mail: String, parola: String): Boolean {
        return !(TextUtils.isEmpty(mail) || TextUtils.isEmpty(parola))
    }
}




