use toeiconline;
create table userEntity (
	userid bigint not null primary key auto_increment,
    name varchar(255) null,
    password varchar(255) null,
    fullname varchar(300) null,
    createddate timestamp null
);

create table roleEntity (
	roleid bigint not null primary key,
    name varchar(100) null
);

use toeiconline;
create table slideBanner (
	slidename varchar(255) null,
	slidecontent varchar(255) null,
	slideimage varchar(255) null,
);