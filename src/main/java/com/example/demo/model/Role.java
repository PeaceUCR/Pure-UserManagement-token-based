package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;


public enum  Role implements GrantedAuthority {
    /*
    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
    */

    ROLE_ADMIN, ROLE_VISITOR;

    public String getAuthority() {
        return name();
    }

}
