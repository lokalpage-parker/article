package com.example.article.data

import java.time.LocalDate

data class CreateUserRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val birthDate: LocalDate
)

data class CreateUserResponse(
    val user: User
)