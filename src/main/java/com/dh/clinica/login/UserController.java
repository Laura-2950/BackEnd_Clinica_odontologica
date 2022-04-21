package com.dh.clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class UserController {

    private AppUserService appUserService;
    @Autowired
    public UserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseEntity<?> toRegister() throws Exception{
        return null;
    }

}
