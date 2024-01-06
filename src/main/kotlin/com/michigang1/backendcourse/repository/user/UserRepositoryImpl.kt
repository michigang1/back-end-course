package com.michigang1.backendcourse.repository.user

import com.michigang1.backendcourse.exception.ResourceByParamNotFound
import com.michigang1.backendcourse.models.User
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestBody

class UserRepositoryImpl : UserRepository {
    private val userStub = mutableListOf<User>()
    override fun getUserById(id: Int): User? {
        return userStub.find { it.id == id }
    }

    override fun getAllUsers(): List<User> {
        return userStub
    }

    override fun addUser(user: User): User {
        if (userStub.filter { it.name == user.name }.isNotEmpty()) {
            return userStub.filter { it.name == user.name }.first()
        }
        user.id = userStub.count()
        userStub.add(user)
        return userStub.last()
    }

    override fun deleteUserById(@RequestBody id: Int): Boolean {
        val user = userStub.find { it.id == id }
        if (user == null) throw ResourceByParamNotFound()
        else {
            userStub.removeAt(userStub.indexOf(user))
            val isDeleted = userStub.none { it.id == id }

            return isDeleted
        }
    }
}
