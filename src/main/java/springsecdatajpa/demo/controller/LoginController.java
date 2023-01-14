package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.LoginService;
import springsecdatajpa.demo.service.TokenService;
import springsecdatajpa.demo.util.MapperClass;

@RestController
@RequestMapping("/login")
public class LoginController {


    private final TokenService tokenService;
    private final AppUserService appUserService;
    private final LoginService loginService;
    private MapperClass mapperClass = new MapperClass();

    public LoginController(TokenService tokenService, AppUserService appUserService, LoginService loginService) {
        this.tokenService = tokenService;
        this.appUserService = appUserService;
        this.loginService = loginService;
    }

    @PostMapping("")
    public String loginScreen(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        AppUser appUser = appUserService.checkIfValidUser(appUserLoginDTO);
        if(appUser!=null){
            String token = tokenService.generateToken2(appUser);
            System.out.println("We have a good user:: "+ appUser);;
            return token;
        }else {
            return "User and user password not found";
        }
    }

}
