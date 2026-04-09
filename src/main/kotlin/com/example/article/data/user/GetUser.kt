package com.example.article.data.user

import java.time.LocalDate

data class GetUserRequest(
    val id: Int,
    val firstName: String?,
    val lastName: String
)

data class GetUserResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val birthDate: LocalDate
)