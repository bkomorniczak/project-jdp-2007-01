package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.UseCases.SetNewTokenForUserUseCase;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserExpiryTokenDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDbService userDbService;

    @Autowired
    private SetNewTokenForUserUseCase setNewTokenForUserUseCase;

    @PostMapping(value = "createUser")
    public UserDto createUser (@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userDbService.saveUser(userMapper.mapToUser(userDto)));
    }

    @PutMapping(value = "blockUserId")
    public void blockUserId (@RequestParam long userId){
        Optional<User> optionalUser = userDbService.getUser(userId);
        if (optionalUser.isPresent()) {
            optionalUser.get().setStatus(User.STATUS_BLOCK);
        }
    }

    @GetMapping(value = "generateToken")
    public UserExpiryTokenDto generateToken (@RequestBody UserDto userDto) {
        return setNewTokenForUserUseCase.userExpiryTokenDto(userDto);

   }

}
