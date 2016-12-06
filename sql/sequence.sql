-- sequence 

drop sequence USERS_SEQ;

create sequence users_seq
start WITH 1 
increment by 1
maxvalue 9999999999;

drop sequence category_seq;

create sequence category_seq
start WITH 1 
increment by 1
maxvalue 9999999999;

drop sequence post_seq;

create sequence post_seq
start WITH 1 
increment by 1
maxvalue 9999999999;

commit;



