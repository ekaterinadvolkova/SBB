drop database if exists sbb;
create database sbb;
use sbb;


create table train
(
  trainID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
, Number INT NOT NULL
, AvailableSeats INT NOT NULL
, BookedSeats INT NOT NULL
, Occurence VARCHAR(50) NOT NULL
, DepartureTime TIMESTAMP NOT NULL
, foreign key (trainID) references ticket (TrainID)

)  engine=InnoDB;

create table passenger
(
  passengerID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
, FirstName VARCHAR(50) NOT NULL
, LastName  VARCHAR(50) NOT NULL
, BirthDate DATE NOT NULL
, UNIQUE KEY (FirstName, LastName, BirthDate)

)  engine=InnoDB;

create table station (
  StationID INT PRIMARY KEY NOT NULL AUTO_INCREMENT
, Name VARCHAR( 50) NOT NULL

) engine = InnoDB;

create table timetable (

  TimetableID INT NOT NULL AUTO_INCREMENT PRIMARY KEY
, StationID INT NOT NULL
, TrainID INT NOT NULL
, DepartureTime TIMESTAMP NOT NULL
, foreign key (StationID) references station (StationID)
, foreign key (TrainID) references train (TrainID)

)  engine=InnoDB;

create table ticket (

  PassengerID INT NOT NULL
, TrainID INT NOT NULL
, TimetableID INT NOT NULL
, foreign key (PassengerID) references passenger (PassengerID)
, foreign key (TrainID) references train (TrainID)

)  engine=InnoDB;