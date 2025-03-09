package com.example.newsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

    private var _newsList = MutableLiveData<List<News>>()

    val newsList : LiveData<List<News>> get() = _newsList

    fun addNews(){
        var news = News(generateRandomTitle(), generateRandomAuthor(), generateRandomContent())
        var updatedList = _newsList.value?.toMutableList() ?: mutableListOf()
        updatedList.add(news)
        _newsList.value= updatedList
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