package com.michigang1.backendcourse.service.user

import com.michigang1.backendcourse.models.User
import com.michigang1.backendcourse.repository.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val repository: UserRepository) : UserService {
    override suspend fun getUserById(id: Int): User? {
        return repository.getUserById(id)
    }

    override suspend fun getAllUsers(): List<User> {
        return repository.getAllUsers()
    }

    override suspend fun addUser(user: User): User {
        return repository.addUser(user)
    }

    override suspend fun deleteUserById(id: Int): Boolean {
        return repository.deleteUserById(id)
    }
}