package springsecdatajpa.demo.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO {


    private int id;
    private String userName;
    private String email;
    private String token;

}
