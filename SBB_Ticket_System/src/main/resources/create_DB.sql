drop database if exists sbb_db;
create database sbb_db;
use sbb_db;

create table train (
                       id bigint not null auto_increment primary KEY,
                       Number int,
                       Available_seats smallint
)  engine=InnoDB;

create table route_Stations (
                      id bigint not null auto_increment primary key,
                      Departure_Station varchar(50),
                      Destination_Station varchar(50),
                      foreign key (Departure_Station) references station (id),
                      foreign key (Destination_Station) references station (id)
) engine = InnoDB;

create table station (
                         id bigint not null auto_increment primary key,
                         Name varchar(50) not null

)  engine=InnoDB;

create table passenger (
                           id bigint not null auto_increment primary key,
                           First_Name varchar(50) not null,
                           Last_Name varchar(50),
                           Birth_Date date,
                           unique key (first_name, last_name, Birth_Date)

)  engine=InnoDB;


create table timetable (
                       id bigint not null auto_increment primary KEY,
                       Station_id bigint,
                       Train_id bigint,
                       Departure_Time timestamp,
                       foreign key (station_id) references station (id),
                       foreign key (Train_id) references train (id)
)  engine=InnoDB;

create table ticket (
                        id bigint not null auto_increment primary KEY,
                        Passenger_id bigint,
                        Train_id bigint,
                        foreign key (Passenger_id) references passenger (id)
)  engine=InnoDB;







