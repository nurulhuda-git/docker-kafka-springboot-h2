package:
	mvnw clean package -DskipTests
build:
	docker-compose build
run:
	docker-compose up -d
run-follow:
	docker-compose up
stop:
	docker-compose down
stop-release:
	docker-compose down --rmi local
ps:
	docker ps -a
logs-app:
	docker container logs app