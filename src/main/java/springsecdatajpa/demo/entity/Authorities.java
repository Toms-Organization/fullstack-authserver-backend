package springsecdatajpa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "authorities")
@NoArgsConstructor
public class Authorities implements GrantedAuthority {

    @Id
    private int id;
    private String levelOfAuthority;

    @Override
    public String getAuthority() {
        return levelOfAuthority;
    }
}