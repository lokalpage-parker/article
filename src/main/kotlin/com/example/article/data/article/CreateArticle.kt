package com.example.article.data.article

import com.example.article.entity.Article

data class CreateArticleRequest(
    val title: String,
    val description: String,
)

data class CreateArticleResponse(
    val article: Article,
)
