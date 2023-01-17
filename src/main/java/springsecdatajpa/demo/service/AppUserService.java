package springsecdatajpa.demo.service;

import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser checkIfValidUser(String userName, String userPassword) {

        // TODO: take the Password and hash it --> Compare to the stored hash
        AppUser thisUser = appUserRepository.findAppUserByUserNameAndUserPassword(userName, userPassword);
        System.out.println(thisUser);
        if (thisUser != null) {
            System.out.println("User Found in the database and successfully fetched");
            return thisUser;
        } else {
            System.out.println("User and Password not found");
            return null;
        }
    }

    public void saveAppUser(AppUser u1) {
        appUserRepository.save(u1);
    }

    public AppUser doesUserExist(String appUserName) {
        return appUserRepository.findAppUserByUserName(appUserName);
    }
}
