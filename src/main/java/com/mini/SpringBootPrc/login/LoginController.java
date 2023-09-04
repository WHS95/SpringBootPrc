package com.mini.SpringBootPrc.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    //http://localhost:8080/login?name={name}
    @RequestMapping("login")
    public String Login(@RequestParam String name, ModelMap model){
        model.put("name", name);
        System.out.println("name = " + name);
        return  "login";
    }
}

