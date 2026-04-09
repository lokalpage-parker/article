package com.example.article.service

import com.example.article.data.like.LikeArticleRequest
import com.example.article.data.like.LikeArticleResponse
import com.example.article.data.like.UnLikeArticleRequest
import com.example.article.data.like.UnLikeArticleResponse
import com.example.article.entity.UserArticleLike
import com.example.article.repository.UserArticleLikeRepository
import org.springframework.stereotype.Service
import java.time.Clock

@Service
class UserArticleLikeService(
    private val clock: Clock,
    private val userArticleLikeRepository: UserArticleLikeRepository,
) {
    enum class UserArticleLikeState {
        ACTIVE,
        INACTIVE
    }

    fun likeArticle(request: LikeArticleRequest): LikeArticleResponse {

        // 이미 있는 것인지 찾고 있으면 오류를 발생시켜서 insert 로직이 실행되지 않게한다.
        val existing = userArticleLikeRepository.findByUserIdAndArticleIdAndState(
            userId = request.userId,
            articleId = request.articleId,
            state = UserArticleLikeState.ACTIVE.name
        )
        if (existing != null) {
            throw Exception("already liked")
        }
        val now = clock.instant()
        var userArticleLikeEntity = UserArticleLike(
            userId = request.userId,
            articleId = request.articleId,
            state = UserArticleLikeState.ACTIVE.name,
            createdAt = now,
            updatedAt = now,
        )
        userArticleLikeEntity = userArticleLikeRepository.save(userArticleLikeEntity)
        return LikeArticleResponse(
            userArticleId = userArticleLikeEntity.id ?: 0
        )
    }

    fun unlikeArticle(request: UnLikeArticleRequest): UnLikeArticleResponse {
        // 1. 있는지 찾고 없으면 오류
        val existing = userArticleLikeRepository.findByUserIdAndArticleIdAndState(
            userId = request.userId,
            articleId = request.articleId,
            state = UserArticleLikeState.ACTIVE.name
        ) ?: throw Exception("not found like")

        // 2. 있으면 state 를 INACTIVE 로 변경하기
        val updated = existing.copy(
            state = UserArticleLikeState.INACTIVE.name,
            updatedAt = clock.instant()
        )
        userArticleLikeRepository.save(updated)

        return UnLikeArticleResponse(
            userArticleId = updated.id ?: 0
        )
    }
}
