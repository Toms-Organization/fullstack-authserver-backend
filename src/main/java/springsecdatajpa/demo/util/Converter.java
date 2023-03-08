package springsecdatajpa.demo.util;

import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserDTO;

public class Converter {

    public AppUserDTO convertAppUserToDTO(AppUser appUser, String token) {
        return new AppUserDTO(appUser.getId(), appUser.getUserName(), appUser.getEmail(), token);
    }
}
