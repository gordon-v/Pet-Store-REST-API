package com.gordon.petstore

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "username", unique = true, nullable = false)
    val username: String,
    @Column(name = "first_name", nullable = false)
    var firstName: String,
    @Column(name = "last_name", nullable = false)
    var lastName: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "phone", nullable = false)
    var phone: String,
    @Column(name = "user_status", nullable = false)
    var userStatus: Int
) {
    constructor(
        username: String,
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        phone: String,
        userStatus: Int
    ) : this(
        0L, username, firstName, lastName, email, password, phone, userStatus
    )
}
