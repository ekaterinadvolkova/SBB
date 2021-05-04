package com.javaschool.ev.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Station extends AbstractDomain{
    private String name;

    public Station(String name) {
        this.name = name;
    }
}
