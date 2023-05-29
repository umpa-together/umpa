package com.umpa.core.controller.v1.auth

import com.umpa.core.controller.v1.auth.request.SignUpRequest
import com.umpa.core.controller.v1.auth.response.SignUpResponse
import com.umpa.core.domain.user.UserCreateService
import com.umpa.response.CommonApiResponse
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class AuthController(
    val userCreateService: UserCreateService
) {
    @PostMapping("/users")
    fun signUp(
        @Valid @RequestBody
        body: SignUpRequest
    ): CommonApiResponse<SignUpResponse> {
        val result = userCreateService.create(body.toDomain())
        return CommonApiResponse.success(SignUpResponse(result))
    }

    @PostMapping("/login")
    fun login() {
    }

    @PostMapping("/logout")
    fun logout() {
    }

    @PostMapping("/users/remove")
    fun deActive() {
    }
}
