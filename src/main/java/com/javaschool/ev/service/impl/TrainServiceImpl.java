package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.RouteDAO;
import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.dao.api.TimetableDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.dao.impl.TrainDAOImpl;
import com.javaschool.ev.domain.Route;
import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.mapper.TrainMapper;
import com.javaschool.ev.service.api.TrainService;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainMapper trainMapper;

    public void trainMapper(TrainMapper trainMapper) {
        this.trainMapper = trainMapper;
    }

    private TrainDAO trainDAO = new TrainDAOImpl();
    @Autowired
    public void setTrainDAO(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }

    @Autowired
    private TimetableDAO timetableDAO;
    public void timetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    private RouteDAO routeDAO;
    @Autowired
    public void setRouteDAO(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    private StationDAO stationDAO;
    @Autowired
    public void setStationDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    @Override
    public List<Train> allTrains() {
        return trainDAO.allTrains();
    }

    @Override
    public void add(TrainDTO trainDTO) {
        Train train = trainMapper.convertRecord(trainDTO);
        trainDAO.add(train);
        Route newRoute = createNewRoute(trainDTO, train);
        Set<Route> routeSet = new HashSet<>();
        routeSet.add(newRoute);
        train.setRoutes(routeSet);
        trainDAO.edit(train);
    }


    public Route createNewRoute(TrainDTO trainDTO, Train train) {
        Route route = new Route();
        route.setTrain(train);
        route.setDate(trainDTO.getDepartureDate());
        routeDAO.createNewRoute(route);
        //timetable items
        List<Timetable> timetableList = new ArrayList<>();
//        for (int i = 0; i < trainDTO.getTimetable().size(); i++) {
//            TimetableItemDTO timetableItemDTO = trainDTO.getTimetable().get(i);
//            Timetable timetable = timetableItem(timetableItemDTO, route);
//            timetableList.add(timetable);
//        }
//        route.setTimetableList(timetableList);
        routeDAO.editRoute(route);
        return route;
    }

    public Timetable timetableItem(TimetableItemDTO timetableItemDTO, Route route) {
        Timetable timetable = new Timetable();
        LocalDateTime localDateTime = LocalDateTime.of(route.getDate(), timetableItemDTO.getDepartureTime());
        timetable.setDepartureTime(localDateTime);
        timetable.setRoute(route);
        timetable.setStation(stationDAO.getByName(timetableItemDTO.getStationName()));
        timetableDAO.createNewTimetableItem(timetable);
        return timetable;
    }

    @Override
    public void delete(Train train) {
        trainDAO.delete(train);
    }

    @Override
    public void edit(Train train) {
        trainDAO.edit(train);
    }

    @Override
    public Train getById(int trainID) {
        return trainDAO.getById(trainID);
    }

    @Override
    public boolean checkTrain(int number) {
        return trainDAO.checkTrain(number);
    }

}
