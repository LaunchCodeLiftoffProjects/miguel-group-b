package org.launchcode.javawebdevtechjobsauthentication.users;

import org.hibernate.annotations.Type;
import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Column
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean enabled;

    @OneToOne
    private Cart cart;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {};

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = encoder.encode(password);
        this.enabled = enabled;
    }



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, this.password);
    }
}
