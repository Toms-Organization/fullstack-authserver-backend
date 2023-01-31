package springsecdatajpa.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.entity.DTO.CreateAppUserDTO;
import springsecdatajpa.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public void saveAppUser(AppUser u1) {
        appUserRepository.save(u1);
    }

    public AppUser doesUserExist(String appUserName) {
        return appUserRepository.findAppUserByUserName(appUserName);
    }

    public String createNewUser(CreateAppUserDTO createAppUserDTO) {
        AppUser appUser = checkIfUserExists(createAppUserDTO.getUserName());
        if(appUser == null){
            // Go ahead and create
            appUser.setUserName(createAppUserDTO.getUserName());
            appUser.setUserPassword(encodeTheGivenPassword(createAppUserDTO.getUserPassword()));
            appUser.setEmail(createAppUserDTO.getEmail());
            appUserRepository.save(appUser);
            return "User was successfully created";
        }else {
            return "UserName already exists";
        }
    }

    private String encodeTheGivenPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.encode(password);
    }

    private AppUser checkIfUserExists(String userName){
        return appUserRepository.findAppUserByUserName(userName);

    }


}






