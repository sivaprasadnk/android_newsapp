package com.example.newsapp

import java.io.Serializable

data class News(
    var title: String,
    var author: String,
    var content: String
) : Serializable