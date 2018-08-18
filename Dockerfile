FROM mysql:5.7
MAINTAINER zhang
ENV MYSQL_ROOT_PASSWORD=hot2018!
EXPOSE 3306
COPY DDL.sql /docker-entrypoint-initdb.d/
