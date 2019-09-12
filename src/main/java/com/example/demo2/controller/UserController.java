package com.example.demo2.controller;

import com.example.demo2.bean.User;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String ListUsers(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("page", userList);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd"; //跳转到userAdd.html
    }

    @PostMapping("/add")
    public String saveUser(User user) {
        userService.createUser(user);
        return "redirect:/manageruser/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/manageruser/";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/manageruser/";
    }
}
