package com.gordon.petstore

import jakarta.persistence.Column

class CreateUserPayload(
    val username: String,
    var firstName: String,
    var lastName: String,
    val email: String,
    val password: String,
    var phone: String,
    var userStatus: Int
)