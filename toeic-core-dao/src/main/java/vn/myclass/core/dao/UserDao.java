package vn.myclass.core.dao;

import vn.myclass.core.data.dao.GenericDao;
import vn.myclass.core.persistence.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
     UserEntity isUserExist(String name, String password);
     UserEntity FindRoleByUser(String name, String password);
     UserEntity FindName(String name);
}
