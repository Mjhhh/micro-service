#!/usr/bin/env bash

docker build -t 101.200.216.3:80/micro-service/course-edge-service:latest .

docker push 101.200.216.3:80/micro-service/course-edge-service:latest