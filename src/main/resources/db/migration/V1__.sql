CREATE TABLE inventory
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_id    BIGINT NULL,
    product_id BIGINT NULL,
    CONSTRAINT pk_inventory PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    prod_name     VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    category      VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    email_id VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_emailid UNIQUE (email_id);

ALTER TABLE user
    ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE inventory
    ADD CONSTRAINT FK_INVENTORY_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE inventory
    ADD CONSTRAINT FK_INVENTORY_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);