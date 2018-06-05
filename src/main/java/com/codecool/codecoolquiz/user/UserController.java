package com.codecool.codecoolquiz.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;
    private UserAccessService userAccessService;

    public UserController(UserService userService, UserAccessService userAccessService) {
        this.userService = userService;
        this.userAccessService = userAccessService;
    }

    @GetMapping(path = "/new")
    public String getUserForm() {
        return "user/userForm";
    }

    @PostMapping(path = "/new")
    public String addUser(@ModelAttribute User user) {

        if(this.userService.getByLogin(user.getLogin()) == null) {

            user.setDate(Timestamp.valueOf(LocalDateTime.now()));
            user.setUserAccess(this.userAccessService.getByName(UserAccess.AccessMode.STUDENT.toString()));
            userService.save(user);

            return "login";
        }
        return "login";
    }


}
