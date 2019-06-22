package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.utils.DrJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class controllerDemo {

    @Autowired
    private UserService userService;


    @RequestMapping(path="/addUser",method=RequestMethod.GET)
    public Object index(
            @RequestParam(value ="username",required = true)String username,
            @RequestParam(value ="portrait")String portrait

    ) {
        User user = new User();
        user.setUsername(username);
        user.setPortrait(portrait);
        try {
            int res =  userService.insert(user);
            return DrJSONResult.ok("添加成功");
        }catch (Exception e){
            return DrJSONResult.errorMsg(e.getMessage());
        }

    }
}
