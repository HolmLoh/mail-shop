
drop table RECEIVING_ADDRESS cascade constraints;

create table RECEIVING_ADDRESS 
(
   raId                NUMBER               not null,
   raCountry           VARCHAR(32),
   raProvince          VARCHAR(32),
   raCity              VARCHAR(32),
   raDetail            VARCHAR(32),
   raPerson            VARCHAR(52),
   raPhone             NUMBER,
   STATE                VARCHAR(32),
   userId                 NUMBER,
   createTime          TIMESTAMP,
   updateTime          TIMESTAMP,
   constraint PK_RECEIVING_ADDRESS primary key (raId)
);

create sequence ADDRESS_SEQ
start with 1
increment by 1
maxvalue 20000
minvalue 1
nocycle
cache 10;

insert into receiving_address values(10,'中国','广东','广州','海珠区','狗剩蛋','1325555','enabled',2,to_timestamp('2018-08-08','yyyy-mm-dd'),to_timestamp('2018-08-08','yyyy-mm-dd'));
insert into receiving_address values(ADDRESS_SEQ.nextval,'中国','广东','广州','海珠区','狗剩蛋','1325555','ENABLED',1,to_timestamp('2018-08-08','yyyy-mm-dd'),to_timestamp('2018-08-08','yyyy-mm-dd'));
