package com.michigang1.backendcourse.controller.user

import com.michigang1.backendcourse.models.User
import org.springframework.http.ResponseEntity

interface UserController {
    suspend fun getAllUsers(): ResponseEntity<List<User>>
    suspend fun getUserById(id: Int): ResponseEntity<User>
    suspend fun addUser(user: User): ResponseEntity<User>
    suspend fun deleteUserById(id: Int): ResponseEntity<Boolean>
}