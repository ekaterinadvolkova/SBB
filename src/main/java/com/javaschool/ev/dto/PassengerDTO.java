package com.javaschool.ev.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PassengerDTO {

    private int passengerID;

    private String firstName;

    private String lastName;

    private Date birthDate;

}
