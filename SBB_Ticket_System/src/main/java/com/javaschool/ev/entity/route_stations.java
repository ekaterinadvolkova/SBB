package com.javaschool.ev.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class route_stations {
    private String Departure_Station;
    private String Destination_Station;
}
