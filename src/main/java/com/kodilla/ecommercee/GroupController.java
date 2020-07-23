package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @GetMapping
    public GroupDto getGroup(@RequestParam Long groupId) {
        return new GroupDto();
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto) {

    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody Long groupId) {
        return new GroupDto();
    }

    @DeleteMapping
    public void deleteGroup(@RequestParam Long groupId) {

    }
}