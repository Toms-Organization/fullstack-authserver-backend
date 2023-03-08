package springsecdatajpa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String userName;
    private String userPassword;
    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable
    private Set<Authorities> authorities;

    public AppUser(String userName, String userPassword, String email, Set<Authorities> authorities) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.authorities = authorities;
    }
}