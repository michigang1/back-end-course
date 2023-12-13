package com.michigang1.backendcourse.repository.user

import com.michigang1.backendcourse.models.User
import org.springframework.stereotype.Repository

interface UserRepository{

    fun getUserById(id: Int): User?

    fun getAllUsers(): List<User>

    fun addUser(user: User): User

    fun deleteUserById(id: Int): Boolean

}