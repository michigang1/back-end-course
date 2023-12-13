package com.michigang1.backendcourse.service.user

import com.michigang1.backendcourse.models.User

interface UserService {
    suspend fun getUserById(id: Int): User?

    suspend fun getAllUsers(): List<User>

    suspend fun addUser(user: User): User

    suspend fun deleteUserById(id: Int): Boolean
}