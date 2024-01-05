package com.based.TBFD.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    private long id;
    @NotBlank
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank
    @JsonProperty("lastName")
    private String lastName;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotBlank
    @JsonProperty("userName")
    private String userName;

    @NotBlank
    @JsonProperty("password")
    private String password;

    @NotBlank
    @JsonProperty("avatar")
    private byte[] avatar;

    public User(long id, String firstName, String lastName, String email, String userName, String password, byte[] avatar) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
    }

    public User(String firstName, String lastName, String email, String userName, String password, byte[] avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
    }

    public User(){}
}
