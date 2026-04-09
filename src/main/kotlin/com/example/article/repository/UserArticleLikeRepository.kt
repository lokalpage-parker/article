package com.example.article.repository

import com.example.article.entity.UserArticleLike
import org.springframework.data.repository.CrudRepository

interface UserArticleLikeRepository : CrudRepository<UserArticleLike, Int>{
        fun findByUserIdAndArticleIdAndState(
            userId: Int,
            articleId: Int,
            state: String,
        ): UserArticleLike?
    }

