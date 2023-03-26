CREATE TABLE book
(
    id          UUID NOT NULL,
    author      VARCHAR(255),
    pages       INTEGER,
    part        INTEGER,
    parts       INTEGER,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_book PRIMARY KEY (id)
);