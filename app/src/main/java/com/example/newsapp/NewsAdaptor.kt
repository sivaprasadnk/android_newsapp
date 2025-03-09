package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.NewsItemBinding

class NewsAdaptor(
    var newsList: List<News>,
) : RecyclerView.Adapter<NewsAdaptor.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context);
        val view = NewsItemBinding.inflate(layoutInflator, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = newsList[position].title
            tvAuthor.text = newsList[position].author
            tvContent.text = newsList[position].content
            val news = News(
                newsList[position].title,
                newsList[position].author,
                newsList[position].content
            )
            cardView.setOnClickListener { it ->
                Toast.makeText(it.context, tvTitle.text.toString(), Toast.LENGTH_SHORT).show()
                val bundle = Bundle().apply {
                    putSerializable("NEWS_ITEM", news)
                }
                it.findNavController().navigate(R.id.detailsFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}