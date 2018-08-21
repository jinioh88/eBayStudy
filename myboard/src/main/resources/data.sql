insert into members(id, name, email, passwd, reg_date)
values( 1, 'oh', 'oh@gmail.com', '{bcrypt}$2a$10$0IKjNgE8fn.5oTSc4V0Cj.9NArYsSZYEZl7NVwV/cPP27dKDOGy76', now());

insert into boards(id, title, content, regdate, member_id) values(1,'hello1','hello1',now(),1);
insert into boards(id, title, content, regdate, member_id) values(2,'hello1','hello1',now(),1);
insert into boards(id, title, content, regdate, member_id) values(3,'hello1','hello1',now(),1);