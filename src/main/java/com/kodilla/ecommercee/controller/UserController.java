package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "createUser")
    public UserDto createUser (@RequestBody UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getUserPassword());
        user.setEmail(userDto.getUserEmail());
        user.setStatus(User.STATUS_ACTIVE);
        user = userRepository.save(user);
        userDto.setId(user.getId());
        userDto.setStatus(user.getStatus());
        return userDto;
    }

    @PutMapping(value = "blockUserId")
    public void blockUserId (@RequestParam long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            optionalUser.get().setStatus(User.STATUS_BLOCK);
        }
    }

   @GetMapping(value = "generateToken")
    public int generateToken (@RequestBody UserDto userDto) {
                    Random random = new Random();
                    return random.nextInt(10);
   }

}
