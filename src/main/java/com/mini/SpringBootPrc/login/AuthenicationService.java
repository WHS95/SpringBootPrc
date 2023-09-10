package com.mini.SpringBootPrc.login;
import org.springframework.stereotype.Service;

@Service
public class AuthenicationService {

    public boolean authenticate(String username, String password){
        boolean  isVaildUserName =  username.equalsIgnoreCase("whs");
        boolean  isVaildPassword =  password.equalsIgnoreCase("123");

        return isVaildUserName && isVaildPassword;

    }
}
