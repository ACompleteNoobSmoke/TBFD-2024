package com.based.TBFD.controller;

import com.based.TBFD.dto.UserDTO;
import com.based.TBFD.model.User;
import com.based.TBFD.model.UserRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RequestMapping("/api/v1/users/")
@RestController
public class UserController {

    private Long userID = 0L;
    final List<UserDTO> userList = new ArrayList<>();

    @PostMapping("saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserRegistration userRegReq){
        System.out.println(userRegReq);
        UserDTO savedTeacher = new UserDTO(
                ++userID,
                userRegReq.getFirstName(),
                userRegReq.getLastName(),
                userRegReq.getUserName(),
                userRegReq.getEmail(),
                "avatar"
        );
        userList.add(savedTeacher);
        HttpStatus status = (savedTeacher != null ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT);
        return new ResponseEntity<>(savedTeacher, status);
    }

    @GetMapping("{userID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userID){
        System.out.println("Searched ID: " + userID);
        UserDTO foundUser = userList.stream()
                .filter(user -> userID.equals(user.userID()))
                .findFirst().orElse(new UserDTO(
                        userID, "MF", "DOOM", "Metal Face Doomster", "MFDOOM@gmail.com", "Viktor Vaughn"
                        )
                );
        HttpStatus status = (foundUser != null ? HttpStatus.FOUND : HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(foundUser, status);
    }
}
