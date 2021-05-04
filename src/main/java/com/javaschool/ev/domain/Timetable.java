package com.javaschool.ev.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Clock;
@Getter
@Setter
@NoArgsConstructor
public class Timetable extends AbstractDomain {
    private Clock departureTime;

}
