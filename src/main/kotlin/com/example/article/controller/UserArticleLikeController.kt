package com.example.article.controller

import com.example.article.data.like.LikeArticleRequest
import com.example.article.data.like.LikeArticleResponse
import com.example.article.data.like.UnLikeArticleRequest
import com.example.article.data.like.UnLikeArticleResponse
import com.example.article.service.UserArticleLikeService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserArticleLikeController(
    private val userArticleLikeService: UserArticleLikeService
) {
    @RequestMapping("/like-article")
    fun likeArticle(
        @RequestBody request: LikeArticleRequest
    ): LikeArticleResponse {
        return userArticleLikeService.likeArticle(request)
    }

    @RequestMapping("/unlike-article")
    fun unlikeArticle(
        @RequestBody request: UnLikeArticleRequest
    ): UnLikeArticleResponse {
        return userArticleLikeService.unlikeArticle(request)
    }
}
