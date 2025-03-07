package com.example.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newsapp.databinding.ActivityDetailsBinding
import com.example.newsapp.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val news = intent.getSerializableExtra("EXTRA_NEWS", News::class.java) as News
        binding.tvDetailsTitle.text = news.title
        binding.tvDetailsAuthor.text = news.author
        binding.tvDetailsContent.text = news.content

        binding.btnBack.setOnClickListener{
            finish()
        }

    }
}