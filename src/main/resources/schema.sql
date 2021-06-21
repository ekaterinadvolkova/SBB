drop database if exists sbb_data;
create database sbb_data;
use sbb_data;

create table train
(
    train_id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    train_number   INT             NOT NULL,
    availableSeats INT             NOT NULL

) engine = InnoDB;

create table station
(
    stationID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name      VARCHAR(50)     NOT NULL

) engine = InnoDB;

create table timetable_item
(
    timetable_id  INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    train_id      INT       NOT NULL,
    stationID     INT       NOT NULL,
    departureTime TIMESTAMP NOT NULL,
    foreign key (stationID) references station (stationID),
    foreign key (`train_id`) references train (`train_id`),
    CONSTRAINT `items_ibfk_1` FOREIGN KEY (`train_id`) REFERENCES train (`train_id`)
) engine = InnoDB;

create table timetable
(

    timetableID   INT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    stationID     INT       NOT NULL,
    departureTime TIMESTAMP NOT NULL,
    foreign key (stationID) references station (stationID)

) engine = InnoDB;


create table myusers
(
    user_id    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username   VARCHAR(45)     NOT NULL,
    password   VARCHAR(45)     NOT NULL,
    firstname  VARCHAR(45)     NOT NULL,
    lastname   VARCHAR(45)     NOT NULL,
    birth_date DATE

) engine = InnoDB;
create table ticket
(
    ticketID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    train_id INT                            NOT NULL,
    user_id  INT                            NOT NULL,

    foreign key (`train_id`) references train (`train_id`),
    foreign key (`user_id`) references myusers (`user_id`),
    CONSTRAINT `items_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES train (`train_id`)

) engine = InnoDB;