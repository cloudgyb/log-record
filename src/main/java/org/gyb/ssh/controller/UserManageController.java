package org.gyb.ssh.controller;

import org.gyb.ssh.config.RecordLog;
import org.gyb.ssh.entity.User;
import org.gyb.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManageController {

    private UserService userService;

    @Autowired
    public UserManageController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 正常处理
     */
    @RecordLog(content = "获取用户列表")
    @GetMapping("/list")
    public List<User> listUser(){
        return userService.getAll();
    }

    /**
     * 抛出了一个异常
     */
    @RecordLog(content = "获取用户列表")
    @GetMapping("/listWithException")
    public List<User> listUserWithException(){
        if (true)
            throw new RuntimeException();
        return userService.getAll();
    }
}
