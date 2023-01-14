package springsecdatajpa.demo.service;

import org.springframework.stereotype.Service;
import springsecdatajpa.demo.repository.AppUserRepository;

@Service
public class LoginService {


    private final AppUserRepository appUserRepository;


    public LoginService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    public String loginToDatabase(){

        return "";
    }


}
