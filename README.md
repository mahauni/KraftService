FIAP Challenge
--------------

Challenge sent by Kraft for a program to store, capture and show about ESG.

This is our project and our entitiesSolution to the project. And our group is 1+ese.

Running with Apache Tomcat 10.0 and JRE 8.

To make this code run you will need to have docker installed.<br>

If you have docker installed, you can clone this repo into your local machine.
```bash
$ git clone https://github.com/mahauni/KraftChallenge
$ cd KraftChallenge
```

After cloning the repo in your local machine you can build the application in a docker container with:
```bash
$ docker-compose up -d
```

and then in your local machine, with windows, in your browser:
http://localhost/app <br>
or in linux you will have to use the ip the that your docker is using:
http://[docker_ip]/app <br>

After you are done with the application you can stop the docker container and remove the docker image with:
```bash
$ docker-compose down && docker image rm tomcat-webapp
```

### Done:
 - [x] Connection to the database
 - [x] All main.java.esgManager.database.DAO for our tables and main.java.esgManager.entities
 - [x] Crated custom data structures for our application (Linked lists for our sprint)
 - [x] Created simple pool of connections to our database
### Doing:
 - [ ] Trying to build up a tomcat website using docker.
 - [ ] If tomcat be too hard, change to WASM or other thing.
### TODO:
 - [ ] Create a display of data
 - [ ] Create a script to make all the Tables and relations for postgres.
 - [ ] Create test (unit, integration test) for our entire application.
 - [ ] Create custom main.java.esgManager.errors and replace it in our codebase.
 - [ ] Create graphs in python to show the results of our data.