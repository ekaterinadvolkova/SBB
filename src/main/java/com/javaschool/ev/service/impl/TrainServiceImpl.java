package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.dao.api.TimetableDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.dao.api.UserDao;
import com.javaschool.ev.dao.impl.TrainDAOImpl;
import com.javaschool.ev.domain.Ticket;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.domain.User;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.mapper.TrainMapper;
import com.javaschool.ev.service.api.StationService;
import com.javaschool.ev.service.api.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import static com.javaschool.ev.service.impl.StationServiceImpl.ALL_AVAILABLE_STATIONS;

@Service
@Transactional
public class
TrainServiceImpl<addTicket> implements TrainService {
    private static final Logger log = LoggerFactory.getLogger(TrainServiceImpl.class);

    @Autowired
    private TrainMapper trainMapper;
    @Autowired
    private StationService stationService;

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

    @Autowired
    private UserDao userDao;

    public void timetableDAO(TimetableDAO timetableDAO) {
        this.timetableDAO = timetableDAO;
    }

    private StationDAO stationDAO;

    @Autowired
    public void setStationDAO(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    public List<TrainDTO> allTrains(String stationName) {
        List<Train> trains;
        if(stationName.equalsIgnoreCase(ALL_AVAILABLE_STATIONS)) {
            trains = trainDAO.allTrains(null);
        } else {
            trains = trainDAO.allTrains(stationName);
        }
        List<TrainDTO> dtos = new ArrayList<>();

        for(Train train : trains) {
            dtos.add(trainMapper.convertToDto(train));
        }
        return dtos;
    }

    @Override
    public void add(TrainDTO trainDTO) {
        Train train = trainMapper.convertToTrain(trainDTO);
        trainDAO.add(train);
    }

    @Override
    public void delete(int trainId) {
        trainDAO.delete(trainId);
    }

    @Override
    public void update(TrainDTO trainDTO) {
        Train train = trainMapper.convertToTrain(trainDTO);
        trainDAO.update(train);
    }

    @Override
    public TrainDTO getById(int trainId) {
        TrainDTO trainDTO;

        if (trainId < 0) {
            trainDTO = new TrainDTO();
        } else {
            trainDTO = trainMapper.convertToDto(trainDAO.getById(trainId));
        }
        trainDTO.setStationNames(stationService.getAvailableStationNames(false));
        return trainDTO;
    }

    @Override
    public TrainDTO updateStationNames(TrainDTO trainDTO) {
        if (null != trainDTO && trainDTO.getStationNames().size() == 0) {
            trainDTO.setStationNames(stationService.getAvailableStationNames(false));
        }
        return trainDTO;
    }

    @Override
    public List<String> validateTrain(TrainDTO trainDTO) {
        List<String> errors = new ArrayList<>();

        if (trainDTO.getTimetable().size() < 2) {
            log.error("Timetable must contain at least 2 items");
            errors.add("Error: Timetable must contain at least 2 items");
        } else {
            LocalDateTime current = LocalDateTime.MIN;
            String currentStationName = "None";

            for (TimetableItemDTO item : trainDTO.getTimetable()) {
                if (item.toLocalDateTime().isBefore(current)) {
                    log.error("Items in Timetable must be consecutive");
                    errors.add("Error: Items in Timetable must be consecutive");
                }
                if (item.getStationName().equalsIgnoreCase(currentStationName)) {
                    log.error("To and From in Timetable cannot have the same Station name");
                    errors.add("Error: To and From in Timetable cannot have the same Station name");
                }

                if (errors.size() > 0) {
                    break;
                }

                current = item.toLocalDateTime();
                currentStationName = item.getStationName();
            }
        }
        return errors;
    }

    @Override
    public boolean checkTrain(int number) {
        return trainDAO.checkTrain(number);
    }


    public List<String> addTicket(int trainID, int userID) {

        List<String> errors = new ArrayList<>();
        //check the ticket from user

        //train does not exist

        //train has left


        trainDAO.addTicket(userID,trainID);

        return errors;
    }
}
