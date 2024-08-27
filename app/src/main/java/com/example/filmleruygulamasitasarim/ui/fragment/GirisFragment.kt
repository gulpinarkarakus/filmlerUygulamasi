package com.example.filmleruygulamasitasarim.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.filmleruygulamasitasarim.R
import com.example.filmleruygulamasitasarim.data.entity.KullaniciViewModel
import com.example.filmleruygulamasitasarim.databinding.FragmentGirisBinding
import com.google.android.material.snackbar.Snackbar

class GirisFragment : Fragment() {

    private lateinit var binding: FragmentGirisBinding
    private lateinit var mKullaniciViewModel: KullaniciViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGirisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel'i başlatmak için ViewModelProvider kullanın
        mKullaniciViewModel = ViewModelProvider(this).get(KullaniciViewModel::class.java)

        // "Kayıt Ol" butonuna basıldığında kayıt ekranına yönlendirme
        binding.kayitUye.setOnClickListener {
            findNavController().navigate(R.id.action_girisFragment_to_kayitGirisFragment)
        }

        // "Giriş Yap" butonuna basıldığında giriş kontrolü
        binding.kayitGiris.setOnClickListener {
            loginUser()
        }
    }

    // Kullanıcı girişini kontrol et
    private fun loginUser() {
        val mail = binding.kayitMail.text.toString()
        val parola = binding.kayitParola.text.toString()

        if (kontrol(mail, parola)) {
            mKullaniciViewModel.getKullaniciByMail(mail).observe(viewLifecycleOwner, Observer { kullanici ->
                if (kullanici != null && kullanici.parola == parola) {
                    Toast.makeText(requireContext(), "Giriş başarılı!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_girisFragment_to_anasayfaFragment)
                } else {
                    Snackbar.make(binding.root, "Hatalı kullanıcı adı veya şifre!", Snackbar.LENGTH_LONG).show()
                }
            })
        } else {
            Snackbar.make(binding.root, "Kullanıcı adı veya şifre boş olamaz!", Snackbar.LENGTH_LONG).show()
        }
    }

    // Boş alan kontrolü
    private fun kontrol(mail: String, parola: String): Boolean {
        return mail.isNotEmpty() && parola.isNotEmpty()
    }
}

