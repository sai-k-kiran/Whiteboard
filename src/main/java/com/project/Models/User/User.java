package com.project.Models.User;

import com.project.Models.Design.Design;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_num")
    private String phoneNum;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.REMOVE)
    private List<Design> designs;

    public User() {}

    public User(String name, String email, String companyName, String phoneNum, String location, String password) {
        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.phoneNum = phoneNum;
        this.location = location;
        this.password = password;
    }

    public User(Integer id, String name,
                String email, String companyName,
                String phoneNum, String location, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.phoneNum = phoneNum;
        this.location = location;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(companyName, user.companyName) && Objects.equals(phoneNum, user.phoneNum) && Objects.equals(email, user.email) && Objects.equals(location, user.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyName, phoneNum, email, location);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Design> getDesigns() {
        return designs;
    }

    public void setDesigns(List<Design> designs) {
        this.designs = designs;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
