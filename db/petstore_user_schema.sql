CREATE TABLE users
(
    id              BIGSERIAL PRIMARY KEY,
    username        TEXT        NOT NULL UNIQUE,
    firstName       TEXT        NOT NULL,
    lastName        TEXT        NOT NULL,
    email           TEXT        NOT NULL,
    password        TEXT        NOT NULL,
    phone           TEXT        NOT NULL,
    userStatus      INTEGER     NOT NULL
);