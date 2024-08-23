package com.scm.scmController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //User Dashboard
    @RequestMapping(value = "/dashboard")
    public String userDashboard(){

        return "user/dashboard";
    }
    //User Profile

    @RequestMapping(value = "/profile")
    public String userProfile(){

        return "user/profile";
    }
}
