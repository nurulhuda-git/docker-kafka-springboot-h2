# docker-kafka-springboot-h2
This repo contains sample project of producer &amp; consumer using spring boot and apache kafka to add/modify data in h2 database

## Installation

Before we start, You need to make sure that you've installed Java Development Kit in your system.

Make sure you can execute `make` in your terminal. If you can't, you can follow this guide to install some dependency first.

Example successful command result :
```bash
$ make: *** No targets specified and no makefile found.  Stop.
```

WINDOWS (if you got any problems, please check [here](https://stackoverflow.com/questions/2532234/how-to-run-a-makefile-in-windows))
1. Download the [cygwin](http://www.cygwin.com/).
2. Setup it.
3. Done.

Before we start, you need to make sure that you have docker / docker dekstop running in your system. If not, download and install docker first.

[Docker Dekstop for Windows](https://docs.docker.com/docker-for-windows/install/)

[Docker Engine for Linux (Ubuntu)](https://docs.docker.com/engine/install/ubuntu/)

[Docker Desktop for Mac](https://docs.docker.com/docker-for-mac/install/)

After installation make sure you can execute `docker -v` command

Example successful command result :
```bash
$ make
  make: *** No targets specified and no makefile found.  Stop.
```

```bash
$ docker -v
  Docker version 20.10.2, build 2291f61
```

## Run Service
1. git clone this repo.
2. go to the root PATH of this project folder and execute this command to build jar file.
   ```bash
   $ make package
   ```
3. After `BUILD SUCCESS` execute command below to build docker images using `docker-compose`.
   ```bash
   $ make build
   ```
4. After `Successfully build docker images`, execute command below to run the service.
   ```bash
   $ make run
   ```

5. To stop the service
   ```bash
   $ make stop
   ```
6. To stop and clean everything
   ```bash
   $ make stop-release
   ```

## Usage
1. create `POST REQUEST`
   ```bash
   POST /
   {
	"id" : 2,
	"name" : "User99"
   }
   ```
2. After run `POST REQUEST` check data changes in the database, open your browser and type `http://localhost:8081/h2`
3. Type `jdbc:h2:mem:testdb` into JDBC URL
4. Type `org.h2.Driver` into Driver Class
5. Type `sa` into User Name
6. leave empty for Password
7. Then click `Connect`
8. Inside H2-Console, run `SELECT * FROM akun`
9. And there is the data that you send using `POST REQUEST` exists.

Done.
