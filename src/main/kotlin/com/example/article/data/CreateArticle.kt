package com.example.article.data

data class CreateArticleRequest(
    val title: String,
    val description: String,
)

data class CreateArticleResponse(
    val article: Article,
)
