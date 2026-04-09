package com.example.article.data.article

import com.example.article.entity.Article

data class UpdateArticleRequest(
    val id: Int,
    val title: String,
    val description: String,
)

data class UpdateArticleResponse(
    val article: Article,
)