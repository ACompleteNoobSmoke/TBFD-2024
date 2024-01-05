package com.based.TBFD.dto;

public record UserDTO (
    Long userID,
    String firstName,
    String lastName,
    String userName,
    String email,
    String avatar
){}
