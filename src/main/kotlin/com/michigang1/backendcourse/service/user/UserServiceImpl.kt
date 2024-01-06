package com.michigang1.backendcourse.service.user

import com.michigang1.backendcourse.entity.UserEntity
import com.michigang1.backendcourse.entity.UserEntityRepository
import com.michigang1.backendcourse.models.User
import com.michigang1.backendcourse.repository.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val repository: UserEntityRepository) : UserService {
    override suspend fun getUserById(id: Int): User? {
        return repository.findById(id).orElse(null)?.toUser()
            ?: throw Exception("User not found")
    }

    override suspend fun getAllUsers(): List<User> {
        return repository.findAll().map { it.toUser() }
    }

    override suspend fun addUser(user: User): User {
        if (getAllUsers().contains(user)) {
            throw Exception("User already exists")
        }
        return repository.save(user.toUserEntity()).toUser()
    }

    override suspend fun deleteUserById(id: Int): Boolean {
        repository.deleteById(id)
        return repository.findById(id).isEmpty
    }

}

fun UserEntity.toUser(): User {
    println(this.records)
    return User(
        id = this.id,
        name = this.name,
    )
}

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
    )
}