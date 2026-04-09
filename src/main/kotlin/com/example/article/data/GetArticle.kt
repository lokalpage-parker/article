package com.example.article.data

data class GetArticleRequest(
    val id: Int,
)

data class GetArticleResponse(
    val article: Article,
)
