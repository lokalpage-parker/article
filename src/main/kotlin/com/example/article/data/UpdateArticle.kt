package com.example.article.data

data class UpdateArticleRequest(
    val id: Int,
    val title: String,
    val description: String,
)

data class UpdateArticleResponse(
    val article: Article,
)