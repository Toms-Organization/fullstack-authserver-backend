package springsecdatajpa.demo.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppUserDTO {

    private String userName;
    private String userPassword;
    private String email;

}
