package com.mini.SpringBootPrc.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    //http://localhost:8080/login?name={name}
    @RequestMapping("login22")
    public String Login22(@RequestParam String name, ModelMap model){
        logger.debug("Request params is (debug): {}", name);
        logger.info("Request params is (info): {}", name);
        logger.warn("Request params is (warn): {}", name);

        model.put("name", name);
        System.out.println("name = " + name);
        return  "login";


//        2023-09-05T21:41:26.424+09:00  INFO 20792 --- [nio-8080-exec-1] c.m.SpringBootPrc.login.LoginController  : Request params is (info): whs
//        2023-09-05T21:41:26.425+09:00  WARN 20792 --- [nio-8080-exec-1] c.m.SpringBootPrc.login.LoginController  : Request params is (warn): whs
//        name = whs
    }

    @RequestMapping(value =  "login", method = RequestMethod.GET)
    public String gotoLoginPage(){
        return  "login";
    }

    @RequestMapping("login")
    public String gotoWelcomePage(){
        return  "login";
    }

}

