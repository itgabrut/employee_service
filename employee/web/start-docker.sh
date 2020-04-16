#!/bin/sh

docker build -t ilya/employee .
docker run -p 9000:8080 --name employee ilya/employee