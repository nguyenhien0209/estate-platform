USE estate_platform;

CREATE TABLE role (
  id           BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  rolecode     VARCHAR(255) NOT NULL,
  createddate  TIMESTAMP NULL,
  createdby    VARCHAR(255) NULL ,
  modifieddate TIMESTAMP NULL,
  modifiedby   VARCHAR(255) NULL
)

CREATE TABLE user (
  id BIGINT     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username      VARCHAR(150) NOT NULL ,
  password      VARCHAR(150) NOT NULL ,
  fullname      VARCHAR(150) NULL,
  status        INT NOT NULL,
  roleid        BIGINT NOT NULL,
  createddate   TIMESTAMP NULL,
  modifieddate  TIMESTAMP NULL,
  createdby     VARCHAR(255) NULL,
  modifiedby    VARCHAR(255) NULL
)

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE district (
  id            INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(255) NOT NULL,
  districtcode  VARCHAR(100) NOT NULL ,
  createddate   TIMESTAMP NULL,
  modifieddate  TIMESTAMP NULL,
  createdby     VARCHAR(255) NULL,
  modifiedby    VARCHAR(255) NULL
)

CREATE TABLE building (
  id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR(255) NULL,
  district      VARCHAR(255),
  ward          VARCHAR(255),
  street        VARCHAR(255),
  structure     VARCHAR(255),
  numberofbasement INT,
  buildingarea  DOUBLE ,
  direction     VARCHAR(255),
  levelbuilding VARCHAR(255),
  rentarea      TEXT,
  areadescription VARCHAR(255),
  costrent      INT,
  costdescription VARCHAR(255),
  servicecost   VARCHAR(255),
  carcost       VARCHAR(255),
  motorbikecost VARCHAR(255),
  overtimecost  VARCHAR(255),
  electricitycost VARCHAR(255),
  deposit       VARCHAR(255),
  payment       VARCHAR(255),
  timecontract  VARCHAR(255),
  timedecorator VARCHAR(255),
  managername   VARCHAR(255),
  managerphone  VARCHAR(255),
  commission    VARCHAR(255),
  note          TEXT,
  link          VARCHAR(255),
  location      VARCHAR(255),
  image         VARCHAR(255),
  type          TEXT NULL,
  createddate   TIMESTAMP NULL,
  modifieddate  TIMESTAMP NULL,
  createdby     VARCHAR(255),
  modifiedby    VARCHAR(255)
)

CREATE TABLE assignmentbuilding (
  id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  buildingid    BIGINT NOT NULL,
  staffid       BIGINT NOT NULL,
  createddate   TIMESTAMP ,
  modifieddate  TIMESTAMP ,
  createdby     VARCHAR(255),
  modifiedby    VARCHAR(255),
--   PRIMARY KEY  (buildingid, staffid),
  FOREIGN KEY (buildingid) REFERENCES building(id),
  FOREIGN KEY (staffid) REFERENCES user(id)
)
