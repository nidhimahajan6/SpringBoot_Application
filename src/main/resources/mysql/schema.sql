
DROP TABLE Sample IF EXISTS;

CREATE TABLE Sample (
  ID INT(10) NOT NULL,
  SampleName varchar(20) DEFAULT NULL,
  course varchar(40) DEFAULT NULL,
  supervisor varchar(100) DEFAULT NULL,
  distinctionCount INT
);
