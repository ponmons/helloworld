DROP SEQUENCE MEMBER_SQ;
DROP SEQUENCE MEETING_SQ;
DROP SEQUENCE PAYMENT_SQ;
DROP SEQUENCE NOTIFICATION_SQ;
DROP SEQUENCE CARD_SQ;
DROP SEQUENCE BANK_SQ;

CREATE SEQUENCE MEMBER_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

CREATE SEQUENCE MEETING_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

CREATE SEQUENCE PAYMENT_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

CREATE SEQUENCE NOTIFICATION_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

CREATE SEQUENCE CARD_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

CREATE SEQUENCE BANK_SQ
START WITH 1
MINVALUE 0
MAXVALUE 99999
NOCACHE
NOCYCLE
ORDER;

drop table member cascade constraints;
drop table meeting cascade constraints;
drop table payment cascade constraints;
drop table notification cascade constraints;
drop table card cascade constraints;
drop table bank cascade constraints;
drop view PAY_INFO cascade constraints;
drop view WEB_PUSH_INFO cascade constraints;


create table member(
	memno number(20) primary key,
	memname varchar2(20) not null,
	mempw varchar2(20) not null,
	cardpw varchar2(20),
	email varchar2(20) unique not null,
	account varchar2(30) unique,
	phonenumber number(20),
	deviceid varchar2(200) unique,
	mempic varchar2(200)
);

insert into member values (MEMBER_SQ.NEXTVAL,'정수열','1','1','suyeol3@naver.com','1','01024234','82cfe0b7-b9b8-11e4-86a9-06a6fa0000b9','2');
insert into member values (MEMBER_SQ.NEXTVAL,'문석민','2','2','moon@naver.com','2','01010','0c1a29c6-ad44-11e4-9c06-06a6fa0000b9','3');
insert into member values (MEMBER_SQ.NEXTVAL,'송지윤','3','3','song@naver.com','3','010232342','0c1a29c6-ader-11e4-9c06-06a6fa0000b9','4');
insert into member values (MEMBER_SQ.NEXTVAL,'최성준','4','4','choi@naver.com','4','010432342','0c1a29c-ader-11e4-9c06-06a6fa0000b9','4');
insert into member values (MEMBER_SQ.NEXTVAL,'후후','5','5','song1@naver.com','5','010532342','0c1a296-ader-11e4-9c06-06a6fa0000b9','4');
insert into member values (MEMBER_SQ.NEXTVAL,'허허','6','6','song2@naver.com','6','010632342','0c1a23c6-ader-11e4-9c06-06a6fa0000b9','4');
insert into member values (MEMBER_SQ.NEXTVAL,'키키','7','7','song3@naver.com','7','010732342','0c1a6c6-ader-11e4-9c06-06a6fa0000b9','4');
insert into member values (MEMBER_SQ.NEXTVAL,'하하','8','8','song4@naver.com','8','010832342','0c1a25c6-ader-11e4-9c06-06a6fa0000b9','4');


create table meeting(
	meeting_type number(3) not null,
	meetno number(20) primary key,
	meetname varchar2(20) not null,
	place varchar2(20),
	meetdate date,
	totalfee number(30),
	manageno number(20) not null
);

insert into meeting values (1,MEETING_SQ.NEXTVAL,'kodb','db진흥원','2015-02-25',50000,2);
insert into meeting values (1,MEETING_SQ.NEXTVAL,'kodb','영등포','2015-02-25',80000,2);


create table payment(
	payno number(20) primary key,
	paycheck number(10),
	price number(30) not null,
	meetno number(20) not null,
	memno number(20) not null,
	constraint payment_meetno_fk foreign key(meetno) references meeting(meetno),
	constraint payment_memno_fk foreign key(memno) references member(memno)
);

insert into payment values (PAYMENT_SQ.NEXTVAL,1,10000,2,2);
--insert into payment values (PAYMENT_SQ.NEXTVAL,1,20000,1,2);
--insert into payment values (PAYMENT_SQ.NEXTVAL,1,330000,1,3);

create table notification(
	notificationno number(20) primary key,
	content varchar(2000) not null,
	alramtime date,
	ckno number(3),
	meetno number(20),
	memno number(20) not null,
	constraint notification_meetno_fk foreign key(meetno) references meeting(meetno),
	constraint notification_memno_fk foreign key(memno) references member(memno)
);

create table card(
	cardno number(20) primary key,
	cardname varchar2(20) not null,
	carddate date not null,
	memno number(20) not null,
	constraint card_memno_fk foreign key(memno) references member(memno)
);
insert into card values (1234,'신한','2015-02-28',2);
insert into card values (12345678,'신한','2015-02-28',3);


create table bank(
	bankno number(20) primary key,
	bankname varchar2(20) not null,
	cardno number(20) not null,
	constraint bank_cardno_fk foreign key(cardno) references card(cardno)
);
insert into bank values (BANK_SQ.NEXTVAL,'신한',1234);
insert into bank values (BANK_SQ.NEXTVAL,'신한',12345678);


CREATE OR REPLACE VIEW PAY_INFO AS
 SELECT 
M.MEMNAME,
M.MEMPW,
M.EMAIL,
M.ACCOUNT,
M.PHONENUMBER,
M.CARDPW,
M.MEMNO,
M.MEMPIC,
P.PAYCHECK,
P.PRICE,
T.MEETING_TYPE,
P.MEETNO,
T.TOTALFEE, 
M.DEVICEID
  FROM MEMBER M, PAYMENT P,MEETING T
  WHERE M.MEMNO = P.MEMNO AND T.MEETNO = P.MEETNO;
  
CREATE OR REPLACE VIEW WEB_PUSH_INFO AS
 SELECT 
M.MEMNAME,
N.CONTENT,
N.NOTIFICATIONNO,
N.MEETNO,
N.MEMNO,
N.CKNO,
N.ALRAMTIME
  FROM MEMBER M, NOTIFICATION N
  WHERE M.MEMNO =N.MEMNO;  
  
  
COMMIT;
