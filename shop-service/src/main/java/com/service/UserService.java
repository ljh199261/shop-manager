package com.service;

import com.entity.User;

public interface UserService {
    /**
     * @param id
     * @return
     */
    User selectUser(Integer id);

    /**
     * @param user
     * @return
     */
    int insertUser(User user);

}
