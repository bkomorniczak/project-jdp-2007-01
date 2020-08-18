package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser (final UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUserEmail(),
                userDto.getUserPassword(),
                userDto.getStatus(),
                userDto.getId());
    }

    public UserDto mapToUserDto (final User user) {
        return new UserDto(
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getId());
    }
    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getUserName(), t.getEmail(), t.getPassword(),
                        t.getStatus(), t.getId()))
                .collect(Collectors.toList());
    }

}
