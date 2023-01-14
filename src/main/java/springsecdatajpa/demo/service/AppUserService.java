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

    public AppUser checkIfValidUser(AppUserLoginDTO appUserLoginDTO) {
        System.out.println(appUserLoginDTO.toString());
        AppUser thisUser = appUserRepository.findAppUserByUserNameAndUserPassword(appUserLoginDTO.getUserName(), appUserLoginDTO.getUserPassword());
        System.out.println(thisUser);
        if (thisUser != null) {
            System.out.println("not null");
            return thisUser;
        } else {
            System.out.println("is null....");
            return null;
        }
    }

    public void saveAppUser(AppUser u1) {
        appUserRepository.save(u1);
    }
}
