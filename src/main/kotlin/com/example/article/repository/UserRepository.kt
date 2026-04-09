package com.example.article.repository

import com.example.article.data.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int>