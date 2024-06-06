CREATE TABLE users
(
    id          BIGSERIAL PRIMARY KEY,
    username    TEXT    NOT NULL UNIQUE,
    first_name  TEXT    NOT NULL,
    last_name   TEXT    NOT NULL,
    email       TEXT    NOT NULL,
    password    TEXT    NOT NULL,
    phone       TEXT    NOT NULL,
    user_status INTEGER NOT NULL
);