USE estate_platform;

insert into role(name,rolecode) values('Quản lý','MANAGER');
insert into role(name,rolecode) values('Nhân viên','STAFF');

insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','Nguyễn Văn A',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','Nguyễn Văn B',1,2);
