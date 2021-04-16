
insert into course(id, name, created_date, last_updated_date) 
values(100001, 'Jpa Advanced', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(100002, 'Spring Advanced', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(100003, 'Spring Boot Advanced', sysdate(), sysdate());

/*Use this if you define column name specifically*/
/*
insert into course(id, fullname) values(100001, 'Jpa Advanced');
insert into course(id, fullname) values(100002, 'Spring Advanced');
insert into course(id, fullname) values(100003, 'Spring Boot Advanced');
*/