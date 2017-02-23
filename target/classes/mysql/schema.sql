CREATE TABLE  student  (
   id  int(11) NOT NULL AUTO_INCREMENT,
   studentname  varchar(20) DEFAULT NULL,
   course  varchar(40) DEFAULT NULL,
   supervisor  varchar(100) DEFAULT NULL,
   distinctioncount  tinyint(4) DEFAULT NULL,
   expenses  longtext,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;
