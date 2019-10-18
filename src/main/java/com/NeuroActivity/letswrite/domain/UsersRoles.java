package com.NeuroActivity.letswrite.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UsersRoles implements GrantedAuthority {
    USER, ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
