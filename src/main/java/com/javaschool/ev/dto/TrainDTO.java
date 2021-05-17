package com.javaschool.ev.dto;

import com.javaschool.ev.domain.Occurence;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class TrainDTO {
    private int trainID;
    private int number;
    private int availableSeats;
    private Occurence occurence;
    List<TimetableItemDTO> timetable;

}
