package com.gordon.petstore

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(user: User): User = userRepository.save(user)

    fun createFromList(list: List<User>) {
        for (user in list)
            userRepository.save(user)
    }

    fun getByUsername(username: String): User {
        return userRepository.findByUsername(username) ?: throw IllegalArgumentException("username not found")
    }

    fun updateByUsername(user: User) {
        val userId: Long = getByUsername(user.userName).id
        val userToUpdate = User(
            userId,
            user.userName,
            user.firstName,
            user.lastName,
            user.email,
            user.password,
            user.phone,
            user.userStatus
        )
        create(userToUpdate)
    }

    fun deleteByUsername(username: String) {
        val userToDelete: User = getByUsername(username)
        userRepository.delete(userToDelete)
    }
}