
insert into course(id, name, created_date, last_updated_date) 
values(10001, 'Jpa Advanced', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002, 'Spring Advanced', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003, 'Spring Boot Advanced', sysdate(), sysdate());

/*Use this if you define column name specifically*/
/*
insert into course(id, fullname) values(100001, 'Jpa Advanced');
insert into course(id, fullname) values(100002, 'Spring Advanced');
insert into course(id, fullname) values(100003, 'Spring Boot Advanced');
*/
/*Student*/
/*
insert into student(id, name) values(20001, 'Sekh Mahadi');
insert into student(id, name) values(20002, 'Shekh Rupon');
insert into student(id, name) values(20003, 'Sheikh Niaj');
*/


/*Passport*/
insert into passport(id, number) values(40001, 'AF80012');
insert into passport(id, number) values(40002, 'AG69023');
insert into passport(id, number) values(40003, 'BF67120');

/*Student after one to ne relationship*/
insert into student(id, name, passport_id) values(20001, 'Sekh Mahadi', '40001');
insert into student(id, name, passport_id) values(20002, 'Shekh Rupon', '40002');
insert into student(id, name, passport_id) values(20003, 'Sheikh Niaj', '40003');



/*Review*/
insert into review(id, rating, description) values(50001, '5', 'Great Course');
insert into review(id, rating, description) values(50002, '4', 'Wonderful Course');
insert into review(id, rating, description) values(50003, '5', 'Awesome Course');
