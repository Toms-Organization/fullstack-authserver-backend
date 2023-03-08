package springsecdatajpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecdatajpa.demo.entity.AppUser;

public interface AppUserRepository  extends JpaRepository<AppUser, Integer> {

    AppUser findAppUserByUserName(String appUserName);
    AppUser findByUserName(String appUserName);
}
