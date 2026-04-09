package com.example.article.controller

import com.example.article.data.article.CreateArticleRequest
import com.example.article.data.article.CreateArticleResponse
import com.example.article.data.article.DeleteArticleRequest
import com.example.article.data.article.DeleteArticleResponse
import com.example.article.data.article.GetArticleRequest
import com.example.article.data.article.GetArticleResponse
import com.example.article.data.article.UpdateArticleRequest
import com.example.article.data.article.UpdateArticleResponse
import com.example.article.service.ArticleService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
    val articleService: ArticleService,
) {
    @RequestMapping("/create-article")
    fun createArticle(
        @RequestBody request: CreateArticleRequest,
    ): CreateArticleResponse {
        return articleService.createArticle(request)
    }

    @RequestMapping("/get-article")
    fun getArticle(
        @RequestBody request: GetArticleRequest,
    ): GetArticleResponse {
        return articleService.getArticle(request)
    }
    @RequestMapping("/update-article")
    fun updateArticle(
        @RequestBody request: UpdateArticleRequest,
    ): UpdateArticleResponse {
        return articleService.updateArticle(request)
    }

    @RequestMapping("/delete-article")
    fun deleteArticle(
        @RequestBody request: DeleteArticleRequest,
    ): DeleteArticleResponse {
        return articleService.deleteArticle(request)
    }
}