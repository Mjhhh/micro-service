#!/usr/bin/env bash

docker build -t 101.200.216.3:80/micro-service/api-gateway-zuul:latest .

docker push 101.200.216.3:80/micro-service/api-gateway-zuul:latest