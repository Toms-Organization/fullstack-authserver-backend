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
            AppUser appUser1 = new AppUser();
            appUser1.setUserName(createAppUserDTO.getUserName());
            appUser1.setUserPassword(encodeTheGivenPassword(createAppUserDTO.getUserPassword()));
            appUser1.setEmail(createAppUserDTO.getEmail());
            appUserRepository.save(appUser1);
            System.out.println("We created a new user!");
            return "User was successfully created";
        }else {
            System.out.println("DID NOT ! created a new user!");
            return "UserName already exists";
        }
    }

    private String encodeTheGivenPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.encode(password);
    }

    private AppUser checkIfUserExists(String userName){
        System.out.println("The username entered is: " + userName);
        try{
            AppUser appUser = appUserRepository.findAppUserByUserName(userName);
            appUser.getUserName();
            System.out.println("This is the user:" + appUser.getUserName() + " " + appUser.getEmail());
            return appUser;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User doesnt exist");
            return new AppUser();
        }
    }


}






