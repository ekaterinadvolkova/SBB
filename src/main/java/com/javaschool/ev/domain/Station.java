package com.javaschool.ev.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }
}
