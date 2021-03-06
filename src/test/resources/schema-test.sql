DROP TABLE IF EXISTS comment;
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

CREATE TABLE comment
(
    id          SERIAL PRIMARY KEY,
    description TEXT                        NOT NULL,
    created     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    post_id     INT                         NOT NULL REFERENCES post (id),
    user_id     INT                         NOT NULL REFERENCES users (id)
);

INSERT INTO authorities (authority)
VALUES ('ROLE_USER');
INSERT INTO authorities (authority)
VALUES ('ROLE_ADMIN');

INSERT INTO users (id, username, enabled, password, authority_id)
VALUES (1000,
        'root',
        TRUE,
        'password',
        (SELECT id FROM authorities WHERE authority = 'ROLE_ADMIN')),
       (999,
        'user',
        TRUE,
        'testUserWithSpecialName_user_for_SpringMock_Post_Control_Post_Test',
        (SELECT id FROM authorities WHERE authority = 'ROLE_ADMIN'));

INSERT INTO post (id, name, description, created, user_id)
VALUES (2000, 'post2000', 'pasta', NOW(), 1000);

INSERT INTO comment (id, description, post_id, user_id)
VALUES (3000, 'Comment for success!', 2000, 999);