package springsecdatajpa.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.CreateAppUserDTO;
import springsecdatajpa.demo.repository.AppUserRepository;
import springsecdatajpa.demo.util.Converter;
import springsecdatajpa.demo.util.MapperClass;

@Service
public class LoginService {


    private final AppUserService appUserService;
    private final TokenService tokenService;
    private final Converter converter = new Converter();


    public LoginService(AppUserService appUserService, TokenService tokenService) {
        this.appUserService = appUserService;
        this.tokenService = tokenService;
    }


    public AppUserDTO loginToDatabase(AppUserLoginDTO appUserLoginDTO) {
        AppUserDTO userToReturn = new AppUserDTO();
        AppUser appUser = appUserService.doesUserExist(appUserLoginDTO.getUserName());
        if (appUser != null) {
            boolean successfulLogin = checkPasswordAndUser(appUser, appUserLoginDTO.getUserPassword());
            if (successfulLogin) {
                String token = tokenService.generateToken(appUser);
                userToReturn = converter.convertAppUserToDTO(appUser, token);
                return userToReturn;
            }
        }
        return userToReturn;
    }

    private Boolean checkPasswordAndUser(AppUser appUser, String enteredPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        // matches() compares the entered password to the stored hashversion of it
        return encoder.matches(enteredPassword, appUser.getUserPassword());
    }



}
