package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "myusers")
public class Login {

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}