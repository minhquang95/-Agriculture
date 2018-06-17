package vn.myclass.core.service;

import vn.myclass.core.dto.UserDTO;

import java.util.Map;

public interface UserService {
    UserDTO isUserExist(UserDTO dto);
    UserDTO FindRoleByUser(UserDTO dto);
    Object[] findListenGuidelineByProperty(Map<String,Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    void register(UserDTO dto);
    UserDTO findById(Integer userId);
}
