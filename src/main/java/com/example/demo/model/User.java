package com.example.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends AuditModel {
    //org.springframework.data.annotation.id vs javax.persistence.id
    //https://stackoverflow.com/questions/39643960/whats-the-difference-between-javax-persistence-id-and-org-springframework-data
    @Id
    @javax.persistence.Id
    @GeneratedValue(generator = "uid_generator")
    @SequenceGenerator(
            name = "uid_generator",
            sequenceName = "uid_sequence",
            initialValue = 998,
            allocationSize = 1
    )
    private Long id;

    private String status;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    private String password;
    //https://stackoverflow.com/questions/416208/jpa-map-collection-of-enums
    @ElementCollection(targetClass=Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
