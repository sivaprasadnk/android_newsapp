package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.NewsItemBinding

class NewsAdaptor(
    var newsList:List<News>
): RecyclerView.Adapter<NewsAdaptor.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context);
        val view = NewsItemBinding.inflate(layoutInflator, parent, false)
        return  NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.apply{
            tvTitle.text = newsList[position].title
            tvAuthor.text = newsList[position].author
            tvContent.text = newsList[position].content
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}