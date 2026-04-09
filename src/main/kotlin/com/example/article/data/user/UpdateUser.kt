package com.example.article.data.user

import com.example.article.entity.User

data class UpdateUserRequest(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val password: String?
)

data class UpdateUserResponse(
    val user: User
)