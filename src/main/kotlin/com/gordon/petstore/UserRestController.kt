package com.gordon.petstore

import com.fasterxml.jackson.core.util.RequestPayload
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserRestController(private val userService: UserService) {

    @PostMapping()
    fun create(@RequestBody payload: User): User = userService.create(payload)

    @PostMapping("/createWithList")
    fun createFromList(@RequestBody payload: List<User>){
        userService.createFromList(payload)
    }

    @GetMapping("/{username}")
    fun getByUsername(@PathVariable username: String): User{
        return userService.getByUsername(username)
    }

    @PutMapping("/{username}")
    fun updateByUsername(@PathVariable username: String, @RequestBody payload: User){
        userService.updateByUsername(username, payload)
    }

    @DeleteMapping("/{username}")
    fun deleteByUsername(@PathVariable username: String){
        userService.deleteByUsername(username)
    }

}