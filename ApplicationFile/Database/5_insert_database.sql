use toeiconline;
SELECT * FROM userentity;
INSERT INTO userentity(name, password, fullname, createddate, roleid) VALUES('admin', '123456', 'admin', CURRENT_TIMESTAMP , 1);
INSERT INTO userentity(name, password, fullname, createddate, roleid) VALUES('quang', '123456', 'minhquang', CURRENT_TIMESTAMP , 2);