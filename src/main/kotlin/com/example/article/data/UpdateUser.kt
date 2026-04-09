package com.example.article.data

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