CREATE DATABASE web_shop;
USE web_shop;
# DROP DATABASE web_shop;

# MAIN TABLES
CREATE TABLE wallets (
  id     BIGINT AUTO_INCREMENT,
  amount BIGINT,
  PRIMARY KEY (id)
);
CREATE TABLE payments (
  id        BIGINT AUTO_INCREMENT,
  id_wallet BIGINT   NOT NULL,
  time      DATETIME NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_wallet) REFERENCES wallets (id)
);
CREATE TABLE credit_cards (
  id            BIGINT AUTO_INCREMENT,
  id_payment    BIGINT      NOT NULL UNIQUE,
  serial_number VARCHAR(50) NOT NULL UNIQUE,
  cvv           VARCHAR(10) NOT NULL,
  expire_date   DATE        NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_payment) REFERENCES payments (id)
);
CREATE TABLE images (
  id   BIGINT AUTO_INCREMENT,
  link VARCHAR(200) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE types (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY (id)
);
CREATE TABLE discounts (
  id       BIGINT AUTO_INCREMENT,
  discount DECIMAL NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE products (
  id          BIGINT AUTO_INCREMENT,
  id_image    BIGINT,
  id_discount BIGINT,
  name        VARCHAR(30) NOT NULL,
  version     BIGINT,
  cost        DECIMAL     NOT NULL,
  producer    VARCHAR(20),
  provider    VARCHAR(20),
  size        INT         NOT NULL,
  amount      INT,
  PRIMARY KEY (id),
  FOREIGN KEY (id_image) REFERENCES images (id),
  FOREIGN KEY (id_discount) REFERENCES discounts (id)
);
CREATE TABLE materials (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE roles (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE users (
  id           BIGINT AUTO_INCREMENT,
  id_wallet    BIGINT       NOT NULL UNIQUE,
  email        VARCHAR(50)  NOT NULL UNIQUE,
  username     VARCHAR(30)  NOT NULL UNIQUE,
  password     VARCHAR(100) NOT NULL,
  first_name   VARCHAR(50),
  last_name    VARCHAR(50),
  phone_number VARCHAR(30),
  country      VARCHAR(30),
  city         VARCHAR(30),
  address      VARCHAR(30),
  PRIMARY KEY (id),
  FOREIGN KEY (id_wallet) REFERENCES wallets (id)
);
CREATE TABLE orders (
  id             BIGINT AUTO_INCREMENT,
  id_product     BIGINT   NOT NULL,
  id_consumer    BIGINT   NOT NULL,
  datetime_order DATETIME NOT NULL,
  paid           BIT      NOT NULL,
  delivered      BIT      NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_consumer) REFERENCES users (id)
);
CREATE TABLE shops (
  id           BIGINT AUTO_INCREMENT,
  country      VARCHAR(30),
  city         VARCHAR(30),
  address      VARCHAR(30),
  phone_number VARCHAR(30),
  PRIMARY KEY (id)
);

# CONNECTORS
CREATE TABLE user_role (
  id_user BIGINT NOT NULL,
  id_role BIGINT NOT NULL,
  PRIMARY KEY (id_user, id_role),
  FOREIGN KEY (id_user) REFERENCES users (id),
  FOREIGN KEY (id_role) REFERENCES roles (id)
);
CREATE TABLE product_material (
  id_product  BIGINT NOT NULL,
  id_material BIGINT NOT NULL,
  PRIMARY KEY (id_product, id_material),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_material) REFERENCES materials (id)
);
CREATE TABLE product_type (
  id_product BIGINT NOT NULL,
  id_type    BIGINT NOT NULL,
  PRIMARY KEY (id_product, id_type),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_type) REFERENCES types (id)
);

INSERT INTO wallets (id, amount) VALUES ('1', '20');
INSERT INTO wallets (id, amount) VALUES ('2', '20');

INSERT INTO payments (id, id_wallet, time) VALUES ('1', '1', '2000-11-10 10:20:10');

INSERT INTO credit_cards (id, id_payment, serial_number, cvv, expire_date)
VALUES ('1', '1', '200', '200', '2000-11-10');

INSERT INTO images (id, link) VALUES ('1', 'someLink');

INSERT INTO types (id, name) VALUES ('1', 'someName');

INSERT INTO discounts (id, discount) VALUES ('1', '20');

INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('1', NULL, NULL, 'someName1', 1, '10', 'someProducer1', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('2', NULL, NULL, 'someName2', 1, '20', 'someProducer1', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('3', NULL, NULL, 'someName3', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('4', NULL, NULL, 'someName4', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('5', NULL, NULL, 'someName5', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('6', NULL, NULL, 'someName6', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('7', NULL, NULL, 'someName7', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('8', NULL, NULL, 'someName8', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('9', NULL, NULL, 'someName9', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('10', NULL, NULL, 'someName10', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('11', NULL, NULL, 'someName11', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('12', NULL, NULL, 'someName12', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('13', NULL, NULL, 'someName13', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('14', NULL, NULL, 'someName14', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('15', NULL, NULL, 'someName15', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('16', NULL, NULL, 'someName16', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('17', NULL, NULL, 'someName17', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('18', NULL, NULL, 'someName18', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('19', NULL, NULL, 'someName19', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('20', NULL, NULL, 'someName20', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('21', NULL, NULL, 'someName21', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('22', NULL, NULL, 'someName22', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('23', NULL, NULL, 'someName23', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('24', NULL, NULL, 'someName24', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('25', NULL, NULL, 'someName25', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('26', NULL, NULL, 'someName26', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('27', NULL, NULL, 'someName27', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('28', NULL, NULL, 'someName28', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('29', NULL, NULL, 'someName29', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('30', NULL, NULL, 'someName30', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('31', NULL, NULL, 'someName31', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('32', NULL, NULL, 'someName32', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('33', NULL, NULL, 'someName33', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('34', NULL, NULL, 'someName34', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('35', NULL, NULL, 'someName35', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('36', NULL, NULL, 'someName36', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('37', NULL, NULL, 'someName37', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('38', NULL, NULL, 'someName38', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('39', NULL, NULL, 'someName39', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('40', NULL, NULL, 'someName40', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('41', NULL, NULL, 'someName41', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('42', NULL, NULL, 'someName42', 1, '10', 'someProducer2', 'someProvider', '40', '8');
INSERT INTO products (id, id_image, id_discount, name, version, cost, producer, provider, size, amount)
VALUES ('43', NULL, NULL, 'someName43', 1, '10', 'someProducer2', 'someProvider', '40', '8');

INSERT INTO materials (id, name) VALUES ('1', 'someName');

INSERT INTO roles (id, name) VALUES ('1', 'ADMIN');
INSERT INTO roles (id, name) VALUES ('2', 'USER');

INSERT INTO users (id, id_wallet, email, username, password, first_name, last_name, phone_number, country, city, address)
VALUES
  ('1', '1', 'someEmail', 'someUsername', 'somePassword', 'firstName', 'lastName', '103', 'someCountry', 'someCity',
        'someAddress');
INSERT INTO users (id, id_wallet, email, username, password, first_name, last_name, phone_number, country, city, address)
VALUES ('2', '2', 'admin@mail.ru', 'admin', 'admin', 'firstName', 'lastName', '103', 'someCountry', 'someCity',
             'someAddress');

INSERT INTO user_role (id_user, id_role) VALUES ('2', '1');
INSERT INTO user_role (id_user, id_role) VALUES ('1', '2');

INSERT INTO orders (id, id_product, id_consumer, datetime_order, paid, delivered)
VALUES ('1', '1', '1', '2000-11-10 10:20:10', 0, 0);

INSERT INTO product_material (id_product, id_material) VALUES ('1', '1');

INSERT INTO product_type (id_product, id_type) VALUES ('1', '1');

INSERT INTO shops (country, city, address, phone_number) VALUES ('someCountry', 'someCity', 'someAddress', '103');