package com.gordon.petstore

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun create(userPayload: CreateUserPayload): User {
        val userToSave = User(
            userPayload.username,
            userPayload.firstName,
            userPayload.lastName,
            userPayload.email,
            userPayload.password,
            userPayload.phone,
            userPayload.userStatus
        )
        return userRepository.save(userToSave)
    }

    fun createFromList(list: List<User>): List<User> = userRepository.saveAll(list)

    fun getByUsername(username: String) =
        userRepository.findByUsername(username) ?: throw IllegalArgumentException("username not found")


    fun updateByUsername(username: String, updateUserPayload: User): User {

        val user = getByUsername(username)

        user.firstName = updateUserPayload.firstName
        user.lastName = updateUserPayload.lastName
        user.phone = updateUserPayload.phone
        user.userStatus = updateUserPayload.userStatus

        return userRepository.save(user)
    }

    fun deleteByUsername(username: String) {
        val userToDelete = getByUsername(username)
        userRepository.delete(userToDelete)
    }

}