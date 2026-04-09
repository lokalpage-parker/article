package com.example.article.controller

import com.example.article.data.CreateUserRequest
import com.example.article.data.CreateUserResponse
import com.example.article.data.DeleteUserRequest
import com.example.article.data.DeleteUserResponse
import com.example.article.data.GetUserRequest
import com.example.article.data.GetUserResponse
import com.example.article.data.UpdateUserRequest
import com.example.article.data.UpdateUserResponse
import com.example.article.service.UserService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService,
) {
    @RequestMapping("/create-user")
    fun createUser(
        @RequestBody request: CreateUserRequest,
    ): CreateUserResponse {
        return userService.createUser(request)
    }

    @RequestMapping("/get-user")
    fun getUser(
        @RequestBody request: GetUserRequest,
    ): GetUserResponse {
        return userService.getUser(request)
    }

    @RequestMapping("/update-user")
    fun updateUser(
        @RequestBody request: UpdateUserRequest,
    ): UpdateUserResponse {
        return userService.updateUser(request)
    }

    @RequestMapping("/delete-user")
    fun deleteUser(
        @RequestBody request: DeleteUserRequest,
    ): DeleteUserResponse {
        return userService.deleteUser(request)
    }
}