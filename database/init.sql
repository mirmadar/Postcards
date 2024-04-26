CREATE DATABASE IF NOT EXISTS postcards;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON postcards.* TO 'user'@'%';
FLUSH PRIVILEGES;

use postcards;
create table services(
    id bigint auto_increment primary key,
    name varchar(20) not null,
    price varchar(15) not null,
    image varchar(255) not null
);

create table requests(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    phone_number varchar(15) not null
);

insert into services values
(1, 'Открытки', 'от 100 ₽', '1.jpg'),
(2, 'Пригласительные', 'от 200 ₽', '2.jpg'),
(3, 'Буклеты', 'от 190 ₽', '3.jpg'),
(4, 'Визитки', 'от 150 ₽', '4.jpg'),
(5, 'Грамоты и дипломы', 'от 350 ₽', '5.jpg'),
(6, 'Календари', 'от 400 ₽', '6.jpg'),
(7, 'Книги и блокноты', 'от 500 ₽', '7.jpg'),
(8, 'Конверты', 'от 50 ₽', '8.jpg');
