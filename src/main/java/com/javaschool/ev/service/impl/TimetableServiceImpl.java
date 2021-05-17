package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.TimetableDAO;
import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.service.api.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    private TimetableDAO timetableDAO;

    @Autowired
    public TimetableServiceImpl(TimetableDAO timetableDAO){
        this.timetableDAO = timetableDAO;
    }

    @Override
    public Timetable createNewTimetableItem(Timetable timetableItem) {
        timetableDAO.createNewTimetableItem(timetableItem);
        return null;
    }

    @Override
    public List<Timetable> getAllTimetableItems() {
        return timetableDAO.getAllTimetableItems();
    }

    @Override
    public void deleteTimetableItem(int timetableID) {
        timetableDAO.deleteTimetableItem(timetableID);

    }

    @Override
    public void editTimetableItem(Timetable timetableItem) {
        timetableDAO.editTimetableItem(timetableItem);
    }
}
