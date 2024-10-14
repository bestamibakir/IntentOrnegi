package com.bestamibakir.intentornegi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bestamibakir.intentornegi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //activity_main.xml'de oluşturduğumuz butonun onClick fonksiyonu
    fun gonder(view : View){
        //editText'lerdeki bilgileri alıyoruz
        val isimMain = binding.editTextText.text.toString()
        val telefonMain = binding.editTextPhone.text.toString()

        //boş bilgi girilmemesi için kontrol
        if (isimMain == "" || telefonMain == ""){
            Toast.makeText(this,"Lütfen bilgileri eksiksiz giriniz",Toast.LENGTH_LONG).show()
        }else{
            //intent ile bulunduğumuz Activity'den(this) bir başka Activity'ye(SecondActivity) {(aslında class'a)} gidiyoruz.
            val intent = Intent(this,SecondActivity::class.java)
            //putExtra key-value ikilisi şeklinde çalışır
            //"isim" ve "telefon" parametreleri ile isimMain ve telefonMain değişkenlerinin değerlerine diğer Activity'den ulaşabiliriz
            intent.putExtra("isim",isimMain)
            intent.putExtra("telefon",telefonMain)
            //gideceğimiz Activity'yi aldığımız verilerle beraber başlatıyoruz
            startActivity(intent)
        }
    }
}