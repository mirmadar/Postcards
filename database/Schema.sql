CREATE USER IF NOT EXISTS 'user\'@\'%' IDENTIFIED BY 'password';

-- Остальной код остается без изменений:
GRANT SELECT, INSERT, UPDATE, DELETE ON postcards.* TO 'user'@'%';
FLUSH PRIVILEGES;

-- Указываем кодировку при создании базы данных:
CREATE DATABASE IF NOT EXISTS postcards CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE postcards;

-- Создаем таблицы с указанием кодировки:
create table services(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    price varchar(15) not null,
    image varchar(255) not null
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

create table requests(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    phone_number varchar(15) not null
) DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Устанавливаем кодировку соединения перед вставкой данных:
SET NAMES utf8mb4;

-- Вставляем данные:
INSERT INTO services(name, price, image) VALUES
('Открытки', 'от 100 ₽', '1.jpg'),
('Пригласительные', 'от 200 ₽', '2.jpg'),
('Буклеты', 'от 190 ₽', '3.jpg'),
('Визитки', 'от 150 ₽', '4.jpg'),
('Грамоты и дипломы', 'от 350 ₽', '5.jpg'),
('Календари', 'от 400 ₽', '6.jpg'),
('Книги и блокноты', 'от 500 ₽', '7.jpg'),
('Конверты', 'от 50 ₽', '8.jpg');
