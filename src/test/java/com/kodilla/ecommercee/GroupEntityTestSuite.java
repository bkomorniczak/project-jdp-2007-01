package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    private GroupRepository groupRepository;
    private static final String NAME = "TestingGroup";

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveGroup() {
        //Given
        Group group = new Group(NAME);
        //When
        groupRepository.save(group);
        Optional<Group> testSaveGroup = groupRepository.findById(group.getId());
        //Then
        Assert.assertTrue(testSaveGroup.isPresent());

        //Clean
        groupRepository.deleteById(group.getId());
    }

    @Test
    public void testFindAllGroups() {
        //Given
        Group group1 = new Group();
        Group group2 = new Group();
        //When
        long beginningNoOfGroups = groupRepository.findAll().size();
        groupRepository.save(group1);
        groupRepository.save(group2);
        //Then
        Assert.assertEquals(2, groupRepository.findAll().size() - beginningNoOfGroups);

        //Clean
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());

    }

    @Test
    public void testDeleteGroup() {
        //Given
        Group group1 = new Group();
        //When
        groupRepository.save(group1);
        groupRepository.deleteById(group1.getId());
        //Then
        Assert.assertFalse(groupRepository.existsById(group1.getId()));

    }
}