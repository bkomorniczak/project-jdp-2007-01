package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping(value = "createUser")
    public UserDto createUser (@RequestBody UserDto userDto) {
        return new UserDto();
    }

    @PutMapping(value = "blockUserId")
    public void blockUserId (@RequestParam long userId){}

   @GetMapping(value = "generateToken")
    public int generateToken (@RequestBody UserDto userDto) {
                    Random random = new Random();
                    return random.nextInt(10);
   }

}
