package springsecdatajpa.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.CreateAppUserDTO;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.LoginService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*") // @CrossOrigin(origins = "http://localhost:3000/news")
public class LoginController {


    private final LoginService loginService;
    private final AppUserService appUserService;


    public LoginController(LoginService loginService, AppUserService appUserService) {
        this.loginService = loginService;
        this.appUserService = appUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<AppUserDTO> loginScreen(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        System.out.println(appUserLoginDTO.toString());
        AppUserDTO appUserDTO = loginService.loginToDatabase(appUserLoginDTO);
        System.out.println("in Login...");
        return ResponseEntity.ok().body(appUserDTO);
    }


    @PostMapping("/createuser")
    public String createUser(@RequestBody CreateAppUserDTO createAppUserDTO){
        System.out.println("in Createuser...");
        return appUserService.createNewUser(createAppUserDTO);
    }


}
