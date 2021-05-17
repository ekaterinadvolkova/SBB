package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Timetable;

import java.util.List;

public interface TimetableDAO {
    void createNewTimetableItem(Timetable timetableItem);
    List<Timetable> getAllTimetableItems();
    void deleteTimetableItem(long id);
    void editTimetableItem(Timetable timetableItem);
}
