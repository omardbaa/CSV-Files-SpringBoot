package com.myproject.backend.entity;

import javax.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
=======
>>>>>>> fortest

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;
    //@Column(nullable = false)
    private String name;


    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
=======
    private long id;
    private String name;
    private String username;
>>>>>>> fortest
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
<<<<<<< HEAD
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
    )
    private List<Role> roles = new ArrayList<>();


}
=======
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;}

>>>>>>> fortest
