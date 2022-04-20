package com.dh.clinica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    private AppUserService appUserService;
    @Autowired
    public UserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> toRegister(@RequestBody AppUser appUser) throws Exception{

        final UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUsername());


        return ResponseEntity.ok(userDetails);
    }*/


    /*@GetMapping("/")
    public String home(){
        return "<h1> WELCOM </H1>";
    }*/

    @GetMapping("/user")
    public String user(){
        return "<h1> WELCOM USER </H1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> WELCOM ADMIN</H1>";
    }
}
