package com.example.newsapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.NewsItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var newsList = mutableListOf<News>(
            News(generateRandomTitle(), generateRandomAuthor(), generateRandomContent())
        )

        val adapter = NewsAdaptor(newsList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager= LinearLayoutManager(this)



        binding.btnAdd.setOnClickListener{
            Log.d("news length",newsList.size.toString() )
             val newsItem = News(
                 title = generateRandomTitle(),
                 author = generateRandomAuthor(),
                 content = generateRandomContent(),
             )
            newsList.add(newsItem)
            adapter.notifyItemInserted(newsList.size-1)
        }
    }

    private fun generateRandomTitle(): String {
        val titles = listOf(
            "Scientists Unveil a New Discovery",
            "Stock Market Hits Record Highs",
            "Weather Conditions Take a Surprising Turn",
            "Tech Companies Announce Revolutionary Products",
            "A Historic Event Shakes the Nation"
        )
        return titles.random()
    }

    private fun generateRandomAuthor(): String {
        val authors = listOf(
            "Alice Johnson",
            "Michael Smith",
            "Emily Davis",
            "James Wilson",
            "Sophia Martinez"
        )
        return authors.random()
    }

    private fun generateRandomContent(): String {
        val sentences = listOf(
            "Experts believe this could change everything.",
            "Investors are showing confidence in the market.",
            "Citizens are reacting to the major development.",
            "This event will be remembered for years to come.",
            "Researchers are excited about future possibilities.",
            "Technology is evolving at an unprecedented pace.",
            "Government officials have issued a statement.",
            "The public is eagerly awaiting more updates."
        )
        return List(4) { sentences.random() }.joinToString(" ")
    }
}