package com.javaschool.ev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import static com.javaschool.ev.service.impl.StationServiceImpl.ALL_AVAILABLE_STATIONS;

@Getter
@Setter
@NoArgsConstructor
public class WelcomeDTO {
    String selectedStation = ALL_AVAILABLE_STATIONS;
    Set<String> stationNames;
    List<TrainDTO> trains;
    int userId;

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder("WelcomeDTO: { selectedStation= ");
        buff.append(this.selectedStation);
        buff.append(", stationNames.size= ");
        buff.append(this.stationNames == null ? "null" : this.stationNames.size());
        buff.append(", trains.size= ");
        buff.append(this.trains == null ? "null" : this.trains.size());
        buff.append(" }");
        return buff.toString();

    }
}
