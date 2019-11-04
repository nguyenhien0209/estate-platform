USE estate_platform;

insert into role(name,rolecode) values('Quản lý','MANAGER');
insert into role(name,rolecode) values('Nhân viên','STAFF');

insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','Nguyễn Văn A',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','Nguyễn Văn B',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanc','123456','Nguyễn Văn C',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvand','123456','Nguyễn Văn D',1,2);
