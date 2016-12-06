--------------- USERS

delete FROM users where no=2;

insert INTO USERS VALUES(users_seq.nextval, '1', '2', '3', sysdate);

select no, id,name, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as regDate FROM users where id =1 and password=3;

select * from users;

select no from users;

select users_seq.currval from users;

insert INTO BLOG VALUES (3, 'asd', 'asd');

commit;

----------------- BLOG

select b.users_no, b.title, b.logo 
from blog b,(select no from users where id = 1) u
where u.no = b.users_no;

select * from blog;

insert INTO BLOG VALUES(users_no, 'title', 'logo');

update BLOG SET TITLE = '이하민의 블로그', LOGO = 'logo' WHERE USERS_NO = 1;


----------------- category
select * from category;

select rownum from (select no from category) where rownum = 1;

select name from category where users_no =1;

select c.no, c.name, c.des, to_char(c.reg_date,'yyyy-mm-dd hh:mi:ss') as regDate, c.users_no as userNo, p.pno as postNo
from category c, 
	(select category_no, count(*) as pno from post group by category_no) p, 
	(select no from users where id = 1) b
where p.CATEGORY_NO (+)= c.no 
and c.USERS_NO = b.no;

select c.no, c.name, c.des, to_char(c.reg_date,'yyyy-mm-dd hh:mi:ss') as regDate, c.users_no as userNo, p.pno as postNo
from category c, (select category_no, count(*) as pno from post group by category_no) p
where p.CATEGORY_NO (+)= c.no ;

insert INTO CATEGORY values (category_seq.nextval, '네번째카테고리', '내용 설명', sysdate, 1) ;

delete from category;

delete from category where no = 6;

------------------ post
select * FROM POST;

select title, content, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as regDate
from post
where category_no =1;

delete FROM post ;

select p.title, p.content,p.CATEGORY_NO
from post p
where p.CATEGORY_NO = 1;
delete from post;

insert INTO POST values (1, '포스트14', '14', sysdate, 4);

select rownum from (select no from post where category_no=4);

select no from post where category_no=4





