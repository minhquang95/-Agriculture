use toeiconline;

create table listenguideline (
  listenguidelineid bigint not null primary key auto_increment,
  title varchar(512) null,
  image varchar(255) null,
  context text null,
  modifieddate timestamp null,
  createddate timestamp null
);

create table commentEntity (
  commentid bigint not null primary key auto_increment,
  content text null,
  userid bigint NULL,
  listenguidelineid bigint null,
  createddate timestamp null
);