package com.cet.controller;

import com.cet.entity.ResponsePageEntity;
import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserEntity;
import com.cet.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 30952
 */
@RestController
@RequestMapping("/user")
public class
UserController {

    @Resource
    private UserService userService;

    @GetMapping("/findById")
    public UserEntity findById(Long id) {
        return userService.findById(id);
    }

    @PostMapping("/searchByPage")
    public ResponsePageEntity<UserEntity> searchByPage(@RequestBody UserConditionEntity userConditionEntity) {
        return userService.searchByPage(userConditionEntity);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody UserEntity userEntity) {
        return userService.insert(userEntity);
    }

    @PostMapping("/update")
    public int update(@RequestBody UserEntity userEntity) {
        return userService.update(userEntity);
    }

    @PostMapping("/deleteById")
    public int deleteById(Long id) {
        return userService.delete(id);
    }
}
