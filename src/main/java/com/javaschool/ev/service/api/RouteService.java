package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Route;

import java.util.List;

public interface RouteService {

    Route createNewRoute(Route timetableItem);
    List<Route> getAllRoutes();
    List<Route> getTrainRoutes(int trainId);
    Route getRouteById(int routeId);
    //List<Route> getTrainRoutesByQuery(TrainQueryDto trainQuery);
    void deleteRoute(int routeID);
    void editRoute(Route route);

}
