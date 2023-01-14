package springsecdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {


//    AppUser findByUsernameAndUserpassword(String userName, String passWord);
    AppUser findAppUserByUserNameAndUserPassword(String userName, String passWord);

}
