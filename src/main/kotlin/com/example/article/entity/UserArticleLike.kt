package com.example.article.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(name = "user_article_like")
data class UserArticleLike(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val userId: Int,
    val articleId: Int,
    val state: String,
    val createdAt: Instant,
    val updatedAt: Instant
)