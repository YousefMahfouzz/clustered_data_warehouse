MVN = mvn
DOCKER_COMPOSE = docker-compose

.PHONY: all clean build test run stop


all: clean build test


clean:
	$(MVN) clean


build:
	$(MVN) install


test:
	$(MVN) test


run:
	$(DOCKER_COMPOSE) up -d


stop:
	$(DOCKER_COMPOSE) down


logs:
	$(DOCKER_COMPOSE) logs -f


rebuild: clean build run
