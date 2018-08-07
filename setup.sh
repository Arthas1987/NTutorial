#!/bin/bash
docker build -t testmysql:0.0.1 .
docker run --name tutorial-db -p 32773:3306 -d testmysql:0.0.1
