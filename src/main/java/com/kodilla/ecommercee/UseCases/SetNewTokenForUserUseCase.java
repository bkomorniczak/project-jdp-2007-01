package com.kodilla.ecommercee.UseCases;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.dto.UserExpiryTokenDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class SetNewTokenForUserUseCase {

    public UserExpiryTokenDto userExpiryTokenDto (UserDto userDto ) {
        Random random = new Random();
        UserExpiryTokenDto userExpiryTokenDto = new UserExpiryTokenDto();
        userExpiryTokenDto.setKey(random.nextLong());
        userExpiryTokenDto.setExpiryDate(LocalDateTime.now().plusHours(1));
        return userExpiryTokenDto;
    }

}
