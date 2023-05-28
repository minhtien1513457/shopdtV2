package com.example.shopdt.use_case.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotEmpty
    private String username;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String roleId;
}
