package com.example.usercreator.api.controller;

import com.example.usercreator.application.baseDto.GenericResponse;
import com.example.usercreator.application.service.IUserService;
import com.example.usercreator.application.service.dto.user.UserDto;
import com.example.usercreator.application.service.dto.user.UserResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<GenericResponse<UserResponseDto>> saveUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(new GenericResponse<>(HttpStatus.CREATED, userService.save(userDto)), HttpStatus.CREATED);
    }

}