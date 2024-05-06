FROM mysql:latest
RUN rm -rf /var/lib/mysql/*
COPY ./database /docker-entrypoint-initdb.d/
