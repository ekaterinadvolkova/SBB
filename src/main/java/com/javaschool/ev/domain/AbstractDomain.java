package com.javaschool.ev.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@MappedSuperclass
public abstract class AbstractDomain implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    protected Long id;

    //set BirthDate format for passenger
    @JsonIgnore
    @Column(name = "BirthDate", nullable = false)
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date birthDate;



}
