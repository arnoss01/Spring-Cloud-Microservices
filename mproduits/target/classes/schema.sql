CREATE TABLE product
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    titre       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image       VARCHAR(255) NOT NULL,
    prix        INT          NOT NULL
);