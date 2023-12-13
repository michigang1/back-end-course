package com.michigang1.backendcourse.repository.user

import com.michigang1.backendcourse.exception.NoOneOfTwoParamsProvidedException
import com.michigang1.backendcourse.exception.ResourceByParamNotFound
import com.michigang1.backendcourse.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    @Autowired
    @Qualifier("initializeUsers")
    private val userStub = mutableListOf<User>()
    override fun getUserById(id: Int): User? {
        return userStub[id]
    }

    override fun getAllUsers(): List<User> {
        return userStub
    }

    override fun addUser(user: User): User {
        userStub.add(user)
        return userStub.last()
    }

    override fun deleteUserById(id: Int): Boolean {
        val category = userStub.find { it.id == id }
        if (category == null) throw ResourceByParamNotFound()
        else {
            userStub.removeAt(id)
            val isDeleted = userStub.none { it.id == id }

            return isDeleted
        }
    }
}
