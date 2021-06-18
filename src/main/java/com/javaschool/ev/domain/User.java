package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "myusers")
public class User {

    @Id
    @Column(name = "user_id")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "firstname")
    private String firstname;

    @NonNull
    @Column(name = "lastname")
    private String lastname;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private LocalDate birthDate;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthdate() {
        return birthDate;
    }
}