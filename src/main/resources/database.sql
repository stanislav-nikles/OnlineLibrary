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
  gengre_id    BIGINT REFERENCES genres (id),
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


