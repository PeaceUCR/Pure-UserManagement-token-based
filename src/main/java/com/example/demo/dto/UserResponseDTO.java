package com.example.demo.dto;

import com.example.demo.model.Role;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class UserResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String status;
    @ApiModelProperty(position = 2)
    private String username;
    @ApiModelProperty(position = 3)
    private String email;
    @ApiModelProperty(position = 4)
    private Date createdAt;
    @ApiModelProperty(position = 5)
    List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
