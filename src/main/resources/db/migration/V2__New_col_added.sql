CREATE TABLE `role`
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE session
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    token          VARCHAR(255) NULL,
    device_id      VARCHAR(255) NULL,
    ip_address     VARCHAR(255) NULL,
    user_id        BIGINT NULL,
    session_status SMALLINT NULL,
    expired_at     datetime NULL,
    CONSTRAINT pk_session PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id  BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (user_id, roles_id)
);

ALTER TABLE user
    ADD full_name VARCHAR(255) NULL;

ALTER TABLE user
    MODIFY full_name VARCHAR (255) NOT NULL;

ALTER TABLE session
    ADD CONSTRAINT FK_SESSION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES `role` (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES user (id);