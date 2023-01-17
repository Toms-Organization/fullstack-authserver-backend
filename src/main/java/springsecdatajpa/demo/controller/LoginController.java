package springsecdatajpa.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.LoginService;
import springsecdatajpa.demo.service.TokenService;
import springsecdatajpa.demo.util.MapperClass;

@RestController
@RequestMapping("/login")
public class LoginController {


    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public ResponseEntity<AppUserDTO> loginScreen(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        AppUserDTO appUserDTO = loginService.loginToDatabase(appUserLoginDTO);
        return ResponseEntity.ok().body(appUserDTO);
    }


}
