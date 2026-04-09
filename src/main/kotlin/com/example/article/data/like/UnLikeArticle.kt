package com.example.article.data.like

data class UnLikeArticleRequest(
    val userId: Int,
    val articleId: Int,
)

data class UnLikeArticleResponse(
    val userArticleId: Int,
)
