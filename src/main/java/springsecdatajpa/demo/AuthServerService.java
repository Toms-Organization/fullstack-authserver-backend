package springsecdatajpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springsecdatajpa.demo.config.RsaKeyProperties;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.LoginService;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthServerService {

    private final AppUserService appUserService;
    private final LoginService loginService;

    public AuthServerService(AppUserService appUserService, LoginService loginService) {
        this.appUserService = appUserService;
        this.loginService = loginService;
    }

    @PostConstruct
    public void initData() {
        // Add user
        //		AppUser u1 = new AppUser(3,"Bigge", "coolbigge", "bigge@gmail.com", Set.of(new Authorities(1, "read")));
        //		appUserService.saveAppUser(u1);
    }


    public static void main(String[] args) {
        SpringApplication.run(AuthServerService.class, args);
    }


}
