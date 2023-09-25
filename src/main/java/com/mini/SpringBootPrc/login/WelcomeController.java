package com.mini.SpringBootPrc.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }


    // Spring Security를 사용하여 현재 로그인한 사용자의 이름(또는 아이디) 가져오기
    private String getLoggedinUsername(){
        Authentication authenticaton = SecurityContextHolder.getContext().getAuthentication();
        return authenticaton.getName();
    }

}

