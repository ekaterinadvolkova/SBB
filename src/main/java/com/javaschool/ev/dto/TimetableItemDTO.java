package com.javaschool.ev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class TimetableItemDTO {
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
    private String stationName;
    private String departureDateTime;

    public LocalDateTime toLocalDateTime() {
        return LocalDateTime.parse(this.departureDateTime, format);
    }

    public void fromLocalDateTime(LocalDateTime localDateTime) {
        this.departureDateTime = localDateTime.format(format);
    }
}
