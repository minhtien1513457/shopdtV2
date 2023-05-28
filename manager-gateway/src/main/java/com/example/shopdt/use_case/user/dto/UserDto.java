package com.example.shopdt.use_case.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class UserDto {
    private String id;
    private String username;
    private String email;
    private String roleName;
    private Date createdDate;
    private Date updatedDate;
}
