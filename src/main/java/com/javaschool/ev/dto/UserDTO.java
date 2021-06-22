package com.javaschool.ev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    // fields matching DAO
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
