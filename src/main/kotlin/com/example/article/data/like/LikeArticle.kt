package com.example.article.data.like

data class LikeArticleRequest(
    val userId: Int,
    val articleId: Int,
)

data class LikeArticleResponse(
    val userArticleId: Int,
)
