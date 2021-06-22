package com.javaschool.ev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {
    private UserDTO user;
    private TrainDTO train;
}
