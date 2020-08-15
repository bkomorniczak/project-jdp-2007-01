package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GroupDbService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups()    {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(final Long id) {
        return  groupRepository.findById(id);
    }

    public Group saveGroup(final Group group)   {
        return groupRepository.save(group);
    }

    public void deleteGroup(final Long id) {
        groupRepository.deleteById(id);
    }




}
