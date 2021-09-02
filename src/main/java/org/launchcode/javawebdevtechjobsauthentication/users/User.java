//package org.launchcode.javawebdevtechjobsauthentication.users;
//
//import com.sun.istack.NotNull;
//import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "users")
//public class User extends AbstractEntity {
//
////    @Id
////    @Column(name = "user_id")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Integer id;
//
//    @NotNull
//    private String username;
//    private String password;
//    public static boolean enabled;
//
//
//    @NotNull
//    private String pwHash;
//
//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
////    public User() {}
//
////    public User(String username, boolean enabled, String pwHash, Set<Role> roles) {
////        this.username = username;
////        this.enabled = enabled;
////        this.pwHash = pwHash;
////        this.roles = roles;
////    }
//
//    public User( String username, boolean enabled, String password, Set<Role> roles) {
////        this.id = id;
//        this.username = username;
//        this.pwHash = encoder.encode(password);
//        this.enabled = enabled;
//        this.roles = roles;
//    }
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//
//
////    public Integer getId() {
////        return id;
////    }
////
////    public void setId(Integer id) {
////        this.id = id;
////    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public static boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public boolean isMatchingPassword(String password) {
//        return encoder.matches(password, pwHash);
//    }
//}
