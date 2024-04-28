CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON postcards.* TO 'user'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS postcards;
use postcards;

create table services(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    price varchar(15) not null,
    image varchar(255) not null
) DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

create table requests(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    phone_number varchar(15) not null
) DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
