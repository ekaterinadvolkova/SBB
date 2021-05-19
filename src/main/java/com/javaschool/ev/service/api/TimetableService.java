package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.domain.Train;

import java.util.List;

public interface TimetableService {
    Timetable createNewTimetableItem(Timetable timetableItem);

    public List<Timetable> getAllTimetableItems();

    void deleteTimetableItem(Timetable timetableItem);

    void editTimetableItem(Timetable timetableItem);

    Timetable getById(int timetableID);
}
