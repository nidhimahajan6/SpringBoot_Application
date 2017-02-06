CREATE TABLE ikare.`student` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `course` varchar(40) DEFAULT NULL,
  `supervisor` varchar(100) DEFAULT NULL,
  `distinctionCount` tinyint,
  PRIMARY KEY (`ID`)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




ALTER TABLE student MODIFY COLUMN ID INT auto_increment

