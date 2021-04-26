package com.javaschool.ev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class passenger {
    private String First_Name;
    private String Last_Name;
    private Date Birth_date;

}
