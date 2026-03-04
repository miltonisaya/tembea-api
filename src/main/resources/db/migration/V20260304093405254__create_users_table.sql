CREATE TABLE users
(
    id          BIGSERIAL             NOT NULL,
    uuid        VARCHAR(36)           NOT NULL,
    first_name  VARCHAR(255)          NULL,
    middle_name VARCHAR(255)          NULL,
    last_name   VARCHAR(255)          NULL,
    mobile      VARCHAR(255)          NULL,
    sex         VARCHAR(255)          NULL,
    user_type   VARCHAR(255)          NULL,
    email       VARCHAR(255)          NULL,
    password    VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_uuid UNIQUE (uuid);