package springsecdatajpa.demo.util;

import org.modelmapper.ModelMapper;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;

public class MapperClass {


    private final ModelMapper mapper = new ModelMapper();



    public AppUser convertDtoToUser(AppUserLoginDTO appUserLoginDTO) {
        return mapper.map(appUserLoginDTO, AppUser.class);
    }
}
