package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Timetable;

import java.util.List;

public interface TimetableService {
    Timetable createNewTimetableItem(Timetable timetableItem);
    public List<Timetable> getAllTimetableItems();
    void deleteTimetableItem(int timetableID);
    void editTimetableItem(Timetable timetableItem);
}
