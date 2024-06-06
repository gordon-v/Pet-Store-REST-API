package com.gordon.petstore

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "username", unique = true, nullable = false)
    val userName: String,
    @Column(name = "firstName", nullable = false)
    val firstName: String,
    @Column(name = "lastName", nullable = false)
    val lastName: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "phone", nullable = false)
    val phone: String,
    @Column(name = "userStatus", nullable = false)
    val userStatus: Int
)