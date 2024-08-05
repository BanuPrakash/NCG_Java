insert into users (username, password, enabled) values ('rita', '$2a$12$HtLaoxvU14z4RIHaBKnQTeGtwWGGqpV0ySPlDteZSKPcSFNxNUlwO', 1);
insert into users (username, password, enabled) values ('roger', '$2a$12$9bRCo6lmDMHG5vkdJ8tg/.For8RnikjCW6O92eDUdzZuXj.Ln6egu', 1);

insert into authorities values ('rita', 'ROLE_ADMIN');
insert into authorities values ('rita', 'ROLE_CUSTOMER');
insert into authorities values ('roger', 'ROLE_CUSTOMER');
