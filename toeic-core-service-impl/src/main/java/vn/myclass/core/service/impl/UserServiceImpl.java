package vn.myclass.core.service.impl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.ultils.UserBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.isUserExist(dto.getName(), dto.getPassword());

        return UserBeanUtil.entity2Dto(userEntity);
    }

    public UserDTO FindRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = userDao.FindRoleByUser(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(userEntity);
    }

    public Object[] findListenGuidelineByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<UserDTO> result = new ArrayList<UserDTO>();
        Object [] objects = userDao.findProperty(property,sortExpression,sortDirection,offset,limit);
        for(UserEntity item : (List<UserEntity>)objects[1]){
            UserDTO userDTO = UserBeanUtil.entity2Dto(item);
            result.add(userDTO);
        }
        objects[1] = result;
        return objects;
    }


    public void register(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity userEntity = UserBeanUtil.dto2Entity(dto);
        userDao.Save(userEntity);
    }

    public UserDTO findById(Integer userId) {
        UserEntity userEntity = userDao.FindID(userId);
        UserDTO userDTO = UserBeanUtil.entity2Dto(userEntity);
        return userDTO;
    }
}
