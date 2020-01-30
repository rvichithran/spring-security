insert into users (username, password, enabled) values ('foo', 'foo', true);
insert into users (username, password, enabled) values ('bar', 'bar', true);


insert into authorities (username, authority) values ('foo', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('bar', 'ROLE_USER');
