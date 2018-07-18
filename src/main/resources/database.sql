-- Table: genres
CREATE TABLE genres (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

-- Table: authors
CREATE TABLE authors (
  id        BIGSERIAL PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL
);

-- Table: publishers
CREATE TABLE publishers (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- Table: books
CREATE TABLE books (
  id           BIGSERIAL PRIMARY KEY,
  name         VARCHAR(45)  NOT NULL,
  content      VARCHAR(500) NOT NULL,
  page_count   INT          NOT NULL,
  isbn         VARCHAR(100) NOT NULL UNIQUE,
  publish_year BIGINT       NOT NULL,
  genre_id    BIGINT REFERENCES genres (id),
  publisher_id BIGINT REFERENCES publishers (id),
  image        VARCHAR(500)  DEFAULT NULL,
  descr        VARCHAR(5000) DEFAULT NULL,
  rating       INT           DEFAULT nextval(0),
  vote_count   BIGINT        DEFAULT nextval(0)
);

-- Table for mapping author and books: author_book
CREATE TABLE author_book (
  id        BIGSERIAL,
  author_id BIGINT REFERENCES authors (id),
  book_id   BIGINT REFERENCES books (id)
);

-- Insert data
INSERT INTO genres VALUES (1, 'Классика');
INSERT INTO genres VALUES (2, 'Современная проза');
INSERT INTO genres VALUES (3, 'Поэзия, драматургия');
INSERT INTO genres VALUES (4, 'Детские книги');
INSERT INTO genres VALUES (5, 'Бизнес-книги');
INSERT INTO genres VALUES (6, 'Любовные романы');
INSERT INTO genres VALUES (7, 'Детективы');
INSERT INTO genres VALUES (8, 'Фантастика');
INSERT INTO genres VALUES (9, 'Религия');
INSERT INTO genres VALUES (10, 'Юмор');
INSERT INTO genres VALUES (11, 'Наука, образование');
INSERT INTO genres VALUES (12, 'Справочники');
INSERT INTO genres VALUES (13, 'Приключения');
INSERT INTO genres VALUES (14, 'Искусство');
INSERT INTO genres VALUES (15, 'Боевики');

INSERT INTO publishers VALUES (1, 'АСТ/Астрель');
INSERT INTO publishers VALUES (2, 'Эксмо');
INSERT INTO publishers VALUES (3, 'Детская литература');
INSERT INTO publishers VALUES (4, 'Азбука');
INSERT INTO publishers VALUES (5, 'Художественная литература');
INSERT INTO publishers VALUES (6, 'Азбука-Аттикус');
INSERT INTO publishers VALUES (7, 'Центрполиграф');
INSERT INTO publishers VALUES (8, 'Вече');
INSERT INTO publishers VALUES (9, 'Амфора');

INSERT INTO authors VALUES (1, 'Толстой Лев Николаевич');
INSERT INTO authors VALUES (2, 'Пушкин Александр Сергеевич');
INSERT INTO authors VALUES (3, 'Достоевский Фёдор Михайлович');
INSERT INTO authors VALUES (4, 'Гоголь Николай');
INSERT INTO authors VALUES (5, 'Тургенев Иван');

INSERT
  INTO books
VALUES (1, 'Анна Каренина', 'tolstoy-lev-nikolaevich-anna-karenina-ru.pdf', 393, 9781234567897, 2015, 6, 2,
 '9248-tolstoy-lev-nikolaevich-anna-karenina-ru.jpg', null, 0, 0);

INSERT INTO author_book VALUES (1, 1, 1);

INSERT
  INTO books
VALUES (2, 'Борис Годунов', 'pushkin-aleksandr-sergeevich-boris-godunov.pdf', 161, 9781234567898, 2016, 1, 8,
 '7501-pushkin-aleksandr-sergeevich-boris-godunov.jpg', null, 0, 0);

INSERT INTO author_book VALUES (2, 2, 2);

INSERT
  INTO books
VALUES (3, 'Братья Карамазовы', 'dostoevskiy-fedor-mihaylovich-bratya-karamazovy.pdf', 373, 9781234567899, 2014, 1, 9,
 '5715-dostoevskiy-fedor-mihaylovich-bratya-karamazovy.jpg', null, 0, 0);

 INSERT INTO author_book VALUES (3, 3, 3)
