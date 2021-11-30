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
VALUES (2000, 'post2000', 'pasta', now(), 1000);