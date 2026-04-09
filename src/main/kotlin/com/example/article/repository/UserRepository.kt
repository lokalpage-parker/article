package com.example.article.repository

import com.example.article.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>