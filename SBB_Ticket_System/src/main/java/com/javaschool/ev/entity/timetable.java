package com.javaschool.ev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class timetable {
    private station name;
    private LocalDateTime departure_time;
}
