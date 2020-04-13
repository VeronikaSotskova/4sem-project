package ru.itis.semestrproject.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DOCTOR, PATIENT;
    @Override
    public String getAuthority() {
        return name();
    }
}
