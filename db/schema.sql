DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities
(
    id        SERIAL PRIMARY KEY,
    authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    enabled      BOOLEAN DEFAULT TRUE,
    authority_id INT          NOT NULL REFERENCES authorities (id)
);

CREATE TABLE post
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(2000),
    description TEXT,
    created     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    user_id     INT                         NOT NULL REFERENCES users (id)
);

INSERT INTO authorities (authority)
VALUES ('ROLE_USER');
INSERT INTO authorities (authority)
VALUES ('ROLE_ADMIN');

INSERT INTO users (username, enabled, password, authority_id)
VALUES ('root',
        TRUE,
        'password',
        (SELECT id FROM authorities WHERE authority = 'ROLE_ADMIN'));
