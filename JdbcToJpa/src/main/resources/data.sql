/*
drop table person;

create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date date,
   primary key(id)
);
*/
/*
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Sekh Mahadi', 'Bhola',parsedatetime('1988:12:03', 'yyyy:mm:dd'));
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'Shekh Rupon', 'Dhaka',parsedatetime('1997:02:03', 'yyyy:mm:dd'));
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Niaj Morshed', 'Dhaka', parsedatetime('1986:11:09', 'yyyy:mm:dd'));
*/

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10001,  'Mahadi', 'Bhola', '1988-12-03');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10002,  'Shekh Rupon', 'Dhaka', '1997-02-03');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10003,  'Niaj Morshed', 'Dhaka', '1986-11-09');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10004,  'Ariba', 'Dhaka', '2018-11-26');
