#!/bin/bash
docker build -t testmysql:0.1.0 .
docker run --name tutorial-db -p 32774:3306 -d testmysql:0.1.0
