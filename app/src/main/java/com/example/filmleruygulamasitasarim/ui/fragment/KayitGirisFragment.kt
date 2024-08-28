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

        // "Giriş Yap" butonuna tıklama olayını ayarlar ve girisFragment'a geçiş yapar
        binding.kayitGiris2.setOnClickListener {
            findNavController().navigate(com.example.filmleruygulamasitasarim.R.id.action_kayitGirisFragment_to_girisFragment)
        }


        mKullaniciViewModel = ViewModelProvider(this).get(KullaniciViewModel::class.java)
        // "Kayıt Ol" butonuna tıklama olayını ayarlar ve veriyi veritabanına ekler
        binding.kayitGiris.setOnClickListener {
            insertDataToDataBase()
        }
    }

    // Veritabanına veri ekleme
    private fun insertDataToDataBase() {
        // Kullanıcı adı ve şifreyi alır
        val mail = binding.kayitMail.text.toString()
        val parola = binding.kayitParola.text.toString()
        val id = 0

        if (kontrol(mail, parola)) {
            val kullanici = Kullanicilar(0,mail, parola)
            mKullaniciViewModel.kullaniciEkle(kullanici)
            Toast.makeText(requireContext(), "Üyeliğiniz başarıyla oluşturuldu", Toast.LENGTH_SHORT).show()
            findNavController().navigate(com.example.filmleruygulamasitasarim.R.id.action_kayitGirisFragment_to_girisFragment)
        } else {
            // Hata mesajı gösterme
            Snackbar.make(binding.root, "Kullanıcı adı veya şifre boş olamaz!", Snackbar.LENGTH_LONG).show()


            (activity as? AppCompatActivity)?.supportActionBar?.title = "Hata: Kullanıcı adı veya şifre boş"
        }
    }

    // Boş alan kontrolü
    private fun kontrol(mail: String, parola: String): Boolean {
        return !(TextUtils.isEmpty(mail) || TextUtils.isEmpty(parola))
    }
}




