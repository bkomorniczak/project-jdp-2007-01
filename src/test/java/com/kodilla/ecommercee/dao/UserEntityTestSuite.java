package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {

    @Autowired
    private UserRepository userRepository;
    private static final String NAME = "TestUser";

    @Test
    public void testUserSave() {
        //Given
        User user = new User(NAME, 1, 1111L);

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserFindAll() {
        //Given
        User user = new User(NAME, 1, 1L);
        userRepository.save(user);

        //When
        List<User> readUsers = userRepository.findAll();

        //Then
        assertEquals(1, readUsers.size());

        //CleanUp
        userRepository.deleteAll();
    }
}
