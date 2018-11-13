package com.wr.controller;

import com.wr.entity.User;
import com.wr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 王睿 on 2018/5/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
        User user  = userService.login(username);
        if (user!=null){
            if (user.getPassword().equals(password)){
                return "page/page";   //登陆成功
            }else{
                model.addAttribute("message","登录失败");
                return "page/info";
            }
        }else {
            model.addAttribute("message","你输入的用户不存在");
            return "page/info";
        }
    }

    /**
     * 回到登录页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

}
