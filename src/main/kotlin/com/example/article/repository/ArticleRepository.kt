package com.example.article.repository

import com.example.article.data.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Int>
