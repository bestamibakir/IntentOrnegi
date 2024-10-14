package com.bestamibakir.intentornegi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bestamibakir.intentornegi.databinding.ActivityMainBinding
import com.bestamibakir.intentornegi.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //getStringExtra() fonksiyonu ile önceki Activity'den aldığımız verilere "isim" ve "telefon" parametreleri ile ulaşıyoruz
        binding.textView.text = "${intent.getStringExtra("isim")} : ${intent.getStringExtra("telefon")}"
    }
}