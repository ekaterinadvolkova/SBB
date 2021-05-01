<h1> Java School at T-Systems Project </h1> <br>

<h2> Part I </h2>

<p>The task is to write an application that simulates the operation of an information system for a passenger rail company. The subject area and technical requirements are described in more detail below. </p> <br>

<h2> Subject Area </h2> <br>
There are the following types of entities: <br>

<h4> Station :station: </h4>

- Name 
- Timetable
  -   Train number
  -   Departure or arrival time


<h4> Train :train2: </h4>

- Number
- Route stations
- Amount of seats

<h4> Passenger :man: </h4> 

- First Name
- Last Name
- Birth Date


<h4> Ticket :ticket:</h4> 

- Train number
- Fist and last names of the passenger

<h3> The Aplication must provide the following functionalities: </h3>

- For passengers :couple:
  -  search for trains running from station A to station B at a given time interval;
  -  train timetables by station;
  -  purchasing a ticket if 
    -  there are empty seats
    -  a passenger with the same first name, surname and date of birth is not yet registered on the selected train
    -  at least 10 minutes before train departure
    
- For staff :construction_worker:
  - adding new stations, trains
  - view all passengers registered on the train
  - View all trains;

<h3> Technical Requirements :warning: </h3>

- The final requirement is for a multi-user, client-server application with network connectivity.
- All data is stored on the server side. 
- Each client can upload some data, after each change operation the data should be synchronized with the server.
- The client must have a graphical interface.
- The application must handle hardware and software errors. 

<h3>Technologies Used :construction: </h3>

- IDE - Any (Eclipse, IDEA)
- Tomcat 
- DB – MySQL
- Maven 
- JPA
- Spring Framework (except Boot, Data)
- JSP

