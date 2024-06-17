FROM mysql:latest
RUN rm -rf /var/lib/mysql/*
ENV MYSQL_DATABASE=postcards
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password
ENV MYSQL_CHARACTER_SET_SERVER=utf8mb4
ENV MYSQL_COLLATION_SERVER=utf8mb4_unicode_ci
COPY ./database /docker-entrypoint-initdb.d/
