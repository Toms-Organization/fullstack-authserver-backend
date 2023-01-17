package springsecdatajpa.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.CreateAppUserDTO;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.LoginService;

@RestController
@RequestMapping("")
public class LoginController {


    private final LoginService loginService;
    private final AppUserService appUserService;


    public LoginController(LoginService loginService, AppUserService appUserService) {
        this.loginService = loginService;
        this.appUserService = appUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<AppUserDTO> loginScreen(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        AppUserDTO appUserDTO = loginService.loginToDatabase(appUserLoginDTO);
        return ResponseEntity.ok().body(appUserDTO);
    }


    @PostMapping("/createuser")
    public ResponseEntity<String> createUser(@RequestBody CreateAppUserDTO createAppUserDTO){
        appUserService.createNewUser(createAppUserDTO);
        return ResponseEntity.ok().body("The user was added");

    }


}
