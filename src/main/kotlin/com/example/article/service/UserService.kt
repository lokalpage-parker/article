package com.example.article.service

import com.example.article.data.user.CreateUserRequest
import com.example.article.data.user.CreateUserResponse
import com.example.article.data.user.DeleteUserRequest
import com.example.article.data.user.DeleteUserResponse
import com.example.article.data.user.GetUserRequest
import com.example.article.data.user.GetUserResponse
import com.example.article.data.user.UpdateUserRequest
import com.example.article.data.user.UpdateUserResponse
import com.example.article.entity.User
import com.example.article.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Clock

@Service
class UserService(
    val userRepository: UserRepository,
    val clock: Clock,
) {
    fun createUser(request: CreateUserRequest): CreateUserResponse {
        val now = clock.instant()
        val user = User(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            password = request.password,
            birthDate = request.birthDate,
            createdAt = now,
            updatedAt = now,
        )
        val savedUser = userRepository.save(user)
        return CreateUserResponse(user = savedUser)
    }

    fun getUser(request: GetUserRequest): GetUserResponse {
        val user = userRepository.findByIdOrNull(request.id)
            ?: throw Exception("not found user")

        return GetUserResponse(
            id = user.id!!,
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            birthDate = user.birthDate,
        )
    }

    fun updateUser(request: UpdateUserRequest): UpdateUserResponse {
        val user = userRepository.findByIdOrNull(request.id)
            ?: throw Exception("not found user")

        val updatedUser = user.copy(
            firstName = request.firstName ?: user.firstName,
            lastName = request.lastName ?: user.lastName,
            email = request.email ?: user.email,
            password = request.password ?: user.password,
            updatedAt = clock.instant(),
        )
        val savedUser = userRepository.save(updatedUser)
        return UpdateUserResponse(user = savedUser)
    }

    fun deleteUser(request: DeleteUserRequest): DeleteUserResponse {
        if (!userRepository.existsById(request.id)) {
            throw Exception("not found user")
        }
        userRepository.deleteById(request.id)

        return DeleteUserResponse(request.id)
    }
}