package com.cet.controller;

import com.cet.entity.ResponsePageEntity;
import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserDemoEntity;
import com.cet.service.user.UserDemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 30952
 */
@RestController
@RequestMapping("/user")
public class
UserDemoController {

    @Resource
    private UserDemoService userDemoService;

    @GetMapping("/findById")
    public UserDemoEntity findById(Long id) {
        return userDemoService.findById(id);
    }

    @PostMapping("/searchByPage")
    public ResponsePageEntity<UserDemoEntity> searchByPage(@RequestBody UserConditionEntity userConditionEntity) {
        return userDemoService.searchByPage(userConditionEntity);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody UserDemoEntity userDemoEntity) {
        return userDemoService.insert(userDemoEntity);
    }

    @PostMapping("/update")
    public int update(@RequestBody UserDemoEntity userDemoEntity) {
        return userDemoService.update(userDemoEntity);
    }

    @PostMapping("/deleteById")
    public int deleteById(Long id) {
        return userDemoService.delete(id);
    }
}
