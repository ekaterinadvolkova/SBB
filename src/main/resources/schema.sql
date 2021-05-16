drop database if exists sbb_data;
create database sbb_data;
use sbb_data;


create table train
(
    trainID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
    , number INT NOT NULL
    , availableSeats INT NOT NULL
    , occurence VARCHAR(50) NOT NULL

)  engine=InnoDB;

create table route (
routeID INT PRIMARY KEY AUTO_INCREMENT NOT NULL
, trainID INT NOT NULL
, foreign key (trainID) references train (trainID)
) engine = InnoDB;

create table station (
stationID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
, name VARCHAR( 50) NOT NULL

) engine = InnoDB;

create table timetable (

  timetableID INT NOT NULL AUTO_INCREMENT PRIMARY KEY
, stationID INT NOT NULL
, departureTime TIMESTAMP NOT NULL
, routeID INT NOT NULL
, foreign key (stationID) references station (stationID)
, foreign key (routeID) references route (routeID)

)  engine=InnoDB;


create table passenger
(
    passengerID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
    , firstName VARCHAR(50) NOT NULL
    , lastName  VARCHAR(50) NOT NULL
    , birthDate DATE NOT NULL
    , UNIQUE KEY (firstName, lastName, birthDate)

)  engine=InnoDB;


create table seat (

seatID INT PRIMARY KEY AUTO_INCREMENT
, number INT NOT NULL

) engine=InnoDB;

create table ticket (
ticketID INT PRIMARY KEY AUTO_INCREMENT NOT NULL
,  passengerID INT NOT NULL
, routeID INT NOT NULL
, seatID INT NOT NULL
, foreign key (passengerID) references passenger (passengerID)
, foreign key (seatID) references seat (seatID)
, foreign key (routeID) references route (routeID)

)  engine=InnoDB;

create table train_to_timetable
(
    trainID INT NOT NULL
    , timetableID INT NOT NULL
    , foreign key (trainID) references train (trainID)
    , foreign key (timetableID) references timetable (timetableID)

) engine=InnoDB;