use toeiconline;

alter table commentEntity add constraint fk_user_comment foreign key (userid) references userEntity(userid);

alter table commentEntity add constraint fk_listenguideline_comment foreign key (listenguidelineid) references listenguideline(listenguidelineid);