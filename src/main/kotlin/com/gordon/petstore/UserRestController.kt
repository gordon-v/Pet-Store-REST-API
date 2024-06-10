package com.gordon.petstore

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserRestController(private val userService: UserService) {

    @PostMapping()
    fun create(@RequestBody payload: CreateUserPayload): UserResponse = userService.create(payload).let(::mapToUserResponse)

    @PostMapping("/createWithList")
    fun createFromList(@RequestBody payload: List<CreateUserPayload>) =
        userService.createFromList(payload).map(::mapToUserResponse)

    @GetMapping("/{username}")
    fun getByUsername(@PathVariable username: String) =
        userService.getByUsername(username).let(::mapToUserResponse)


    @PutMapping("/{username}")
    fun updateByUsername(@PathVariable username: String, @RequestBody payload: UpdateUserPayload) =
        userService.updateByUsername(username, payload).let(::mapToUserResponse)


    @DeleteMapping("/{username}")
    fun deleteByUsername(@PathVariable username: String) {
        userService.deleteByUsername(username)
    }

    fun mapToUserResponse(user: User): UserResponse {
        return UserResponse(user.id, user.username)
    }

}