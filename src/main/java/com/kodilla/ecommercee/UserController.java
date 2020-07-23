package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public void createUser (@RequestBody UserDto userDto) {    }

    @PostMapping
    public void blockUserId (@RequestParam int userId){}

    @PostMapping
    public int generateToken (@RequestBody UserDto userDto) {
        Random random = new Random();
        return random.nextInt(10);
    }

}
