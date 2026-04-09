package com.example.article.service

import com.example.article.data.article.CreateArticleRequest
import com.example.article.data.article.CreateArticleResponse
import com.example.article.data.article.DeleteArticleRequest
import com.example.article.data.article.DeleteArticleResponse
import com.example.article.data.article.GetArticleRequest
import com.example.article.data.article.GetArticleResponse
import com.example.article.data.article.UpdateArticleRequest
import com.example.article.data.article.UpdateArticleResponse
import com.example.article.entity.Article
import com.example.article.repository.ArticleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Clock

@Service
class ArticleService(
    val articleRepository: ArticleRepository,
    val clock: Clock,
) {
    fun createArticle(request: CreateArticleRequest): CreateArticleResponse {
        val now = clock.instant()
        val article = Article(
            title = request.title,
            description = request.description,
            createdAt = now,
            updatedAt = now,
        )
        val savedArticle = articleRepository.save(article)
        return CreateArticleResponse(
            article = savedArticle,
        )
    }

    fun getArticle(request: GetArticleRequest): GetArticleResponse {
        val article = articleRepository.findByIdOrNull(request.id)
            ?: throw Exception("not found article")

        return GetArticleResponse(article = article)
    }
    fun updateArticle(request: UpdateArticleRequest): UpdateArticleResponse {
        val article = articleRepository.findByIdOrNull(request.id)
            ?: throw Exception("not found article")

        val updatedArticle = article.copy(
            title = request.title,
            description = request.description,
            updatedAt = clock.instant(),
        )
        val savedArticle = articleRepository.save(updatedArticle)
        return UpdateArticleResponse(article = savedArticle)
    }


    fun deleteArticle(request: DeleteArticleRequest): DeleteArticleResponse {
        if (!articleRepository.existsById(request.id)) {
            throw Exception("not found article")
        }
        articleRepository.deleteById(request.id)

        return DeleteArticleResponse(request.id)
    }
}

