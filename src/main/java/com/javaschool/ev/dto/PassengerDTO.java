package com.javaschool.ev.dto;


import lombok.*;
import java.util.Date;

@Data
@Setter @Getter
public class PassengerDTO {

    private int passengerID;

    private String firstName;

    private String lastName;

    private Date birthDate;

}
