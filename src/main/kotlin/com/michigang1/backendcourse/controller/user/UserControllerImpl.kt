package com.michigang1.backendcourse.controller.user

import com.michigang1.backendcourse.models.DeleteEntityResponse
import com.michigang1.backendcourse.models.User
import com.michigang1.backendcourse.service.user.UserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserControllerImpl(private val service: UserService): UserController{


    @GetMapping(value = ["/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
    override suspend fun getAllUsers(): ResponseEntity<List<User>> {
        val list = service.getAllUsers()
        return ResponseEntity.ok(list)
    }

@GetMapping(value = ["/user/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    override suspend fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
        val user = service.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping(value = ["/user"], produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    override suspend fun addUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = service.addUser(user)
        return ResponseEntity.ok(newUser)
    }

@DeleteMapping(value = ["/user/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    override suspend fun deleteUserById(@PathVariable id: Int): ResponseEntity<DeleteEntityResponse> {
        val result = DeleteEntityResponse(service.deleteUserById(id))
        return ResponseEntity.ok(result)
    }

}