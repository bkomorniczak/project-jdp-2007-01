package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @Autowired
    private GroupDbService groupDbService;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupDbService.getGroups());
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupDbService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PostMapping(value = "addGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupDbService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @PutMapping(value = "updateGroup", consumes = APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupDbService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @DeleteMapping(value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        groupDbService.deleteGroup(groupId);
    }
}