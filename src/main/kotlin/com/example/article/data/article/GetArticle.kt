package com.example.article.data.article

import com.example.article.entity.Article

data class GetArticleRequest(
    val id: Int,
)

data class GetArticleResponse(
    val article: Article,
)
